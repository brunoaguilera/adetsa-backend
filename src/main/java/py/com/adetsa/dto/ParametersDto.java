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

import py.com.adetsa.db.domain.ParametersEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "description", "code", "data_type", "status" })
public class ParametersDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "code")
	private String code;
	
	@JsonProperty(value = "status")
	private String status;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static ParametersDto toDTO(ParametersEntity saved) {
		ParametersDto dto = new ParametersDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<ParametersDto> toListDTO(List<ParametersEntity> list) {
		List<ParametersDto> response = new ArrayList<ParametersDto>();
		for (ParametersEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static ParametersEntity toENTITY(ParametersDto saved) {
		ParametersEntity entity = new ParametersEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<ParametersEntity> toListENTITY(List<ParametersDto> list) {
		List<ParametersEntity> response = new ArrayList<ParametersEntity>();
		for (ParametersDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "ParametersDto [id=" + id + ", description=" + description + ", code=" + code + ", status=" + status
				+ ", additionalProperties=" + additionalProperties + ", value=" + value + "]";
	}
}