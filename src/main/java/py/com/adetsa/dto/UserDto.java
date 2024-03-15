package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import py.com.adetsa.db.domain.UserEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "username", "password", "email", "roles" })
public class UserDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "username")
	private String username;

	@JsonProperty(value = "password")
	private String password;

	@JsonProperty(value = "email")
	private String email;
	
	@JsonProperty(value = "admin")
	private boolean admin;

	@JsonProperty(value = "roles")
	private List<RoleDto> roles;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static UserDto toDTO(UserEntity saved) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<UserDto> toListDTO(List<UserEntity> list) {
		List<UserDto> response = new ArrayList<UserDto>();
		for (UserEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static UserEntity toENTITY(UserDto saved) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<UserEntity> toListENTITY(List<UserDto> list) {
		List<UserEntity> response = new ArrayList<UserEntity>();
		for (UserDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", admin=" + admin + ", roles=" + roles + ", additionalProperties=" + additionalProperties + "]";
	}


}
