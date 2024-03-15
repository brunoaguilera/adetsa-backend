package py.com.adetsa.auth.filters;

import static py.com.adetsa.auth.TokenJwtConfig.HEADER_AUTHORIZATION;
import static py.com.adetsa.auth.TokenJwtConfig.PREFIX_TOKEN;
import static py.com.adetsa.auth.TokenJwtConfig.SECRET_KEY;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
//import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import py.com.adetsa.dto.UserDto;
import py.com.adetsa.dto.enums.ConstantsEnum;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		logger.info("#attemptAuthentication - request: {}", request);

		UserDto user = null;
		String username = null;
		String password = null;

		try {
			ServletInputStream servletInputStream = request.getInputStream();
			logger.info("#attemptAuthentication - servletInputStream " + servletInputStream);

			user = new ObjectMapper().readValue(servletInputStream, UserDto.class);
			username = user.getUsername();
			password = user.getPassword();

			logger.info("Username desde request InputStream (raw) {} ", username);
			logger.info("Password desde request InputStream (raw) {} ", password);

		} catch (StreamReadException e) {
			logger.error("#attemptAuthentication - StreamReadException - e: {} ", e);
		} catch (IOException e) {
			logger.error("#attemptAuthentication - IOException - e: {} ", e);
		} catch (Exception e) {
			logger.error("#attemptAuthentication - Exception - e: {} ", e);
		}
		logger.info("#attemptAuthentication - antes de new UsernamePasswordAuthenticationToken");
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		logger.info("#attemptAuthentication - antes de authenticationManager con authToken: " + authToken);
		Authentication authentication = authenticationManager.authenticate(authToken);
		logger.info("#attemptAuthentication - antes de return con authentication: " + authentication);
		return authentication;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		logger.info("#successfulAuthentication - REQUEST - request: {} - response: {} - chain: {} - authResult: {}",
				request, response, chain, authResult);

		String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal())
				.getUsername();

		Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
		boolean isAdmin = roles.stream().anyMatch(r -> r.getAuthority().equals(ConstantsEnum.ROLE_ADMIN.getCod()));
		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));
		claims.put("isAdmin", isAdmin);
		claims.put("username", username);

		String token = Jwts.builder().setClaims(claims).setSubject(username).signWith(SECRET_KEY)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3600000)).compact();

		response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

		Map<String, Object> body = new HashMap<>();
		body.put("token", token);
		body.put("message", String.format("Hola %s, has iniciado sesion con exito!", username));
		body.put("username", username);
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");

		logger.info("#successfulAuthentication - RESPONSE - request: {} - response: {} - chain: {} - authResult: {}",
				request, response, chain, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		logger.info("#unsuccessfulAuthentication - request");

		Map<String, Object> body = new HashMap<>();
		body.put("message", "Error en la autenticacion username o password incorrecto!");
		body.put("error", failed.getMessage());

		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(401);
		response.setContentType("application/json");

		logger.info("#unsuccessfulAuthentication - RESPONSE - response: {} - body: {}", response, body);
	}

}
