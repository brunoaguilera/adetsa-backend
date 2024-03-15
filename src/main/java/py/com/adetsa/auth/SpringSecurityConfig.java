package py.com.adetsa.auth;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import py.com.adetsa.auth.filters.JwtAuthenticationFilter;
import py.com.adetsa.auth.filters.JwtValidationFilter;
import py.com.adetsa.exception.LotteryApplicationException;
import py.com.adetsa.util.JSONUtils;

@Configuration
public class SpringSecurityConfig {

	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);

	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager authenticationManager() throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests().antMatchers("/swagger/**").permitAll().antMatchers("/api-docs/**").permitAll()
				.antMatchers("/help/**").permitAll()

				.antMatchers(HttpMethod.GET, "/socios/**").permitAll()
				.antMatchers(HttpMethod.POST, "/socios/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/socios/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/socios/**").permitAll()
				.anyRequest().authenticated().and()
				.addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
				.addFilter(new JwtValidationFilter(authenticationConfiguration.getAuthenticationManager()))
				.csrf(config -> config.disable())
				.sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.cors(cors -> cors.configurationSource(corsConfigurationSource())).build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		logger.info("#corsConfigurationSource");

		List<String> origins = Arrays.asList("http://localhost:5173", "http://localhost:8080", "http://localhost:8083",
				"http://192.168.100.2:5173", "http://192.168.139.1:5173", "http://192.168.40.1:5173",
				"http://192.168.96.18:5173", "http://186.122.249.38:8080");

		try {
			logger.info("#corsConfigurationSource - origins: {} ", JSONUtils.toJSON(origins));
		} catch (LotteryApplicationException e) {
		}

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(origins);
		config.setAllowedOriginPatterns(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		config.setAllowCredentials(true);

		logger.info("#corsConfigurationSource - config: {} ", config);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		logger.info("#corsConfigurationSource - source: {} ", source);

		return source;
	}

	@Bean
	FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
