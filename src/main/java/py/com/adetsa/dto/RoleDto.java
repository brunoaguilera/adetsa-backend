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

import py.com.adetsa.db.domain.RoleEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name" })
public class RoleDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "name")
	private String name;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public RoleDto() {
		super();
	}
	
	public RoleDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public RoleDto(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static RoleDto toDTO(RoleEntity saved) {
		RoleDto dto = new RoleDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<RoleDto> toListDTO(List<RoleEntity> list) {
		List<RoleDto> response = new ArrayList<RoleDto>();
		for (RoleEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static RoleEntity toENTITY(RoleDto saved) {
		RoleEntity entity = new RoleEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<RoleEntity> toListENTITY(List<RoleDto> list) {
		List<RoleEntity> response = new ArrayList<RoleEntity>();
		for (RoleDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", additionalProperties=" + additionalProperties + "]";
	}
}