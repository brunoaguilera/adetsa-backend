package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import py.com.adetsa.db.domain.CommerceConfigEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "commerce_code", "main_color", "secondary_color", "created_at", "status", "logo1", "logo2",
		"backgroundImage" })
public class CommerceConfigDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "commerce_code")
	private Long commerceCode;

	@JsonProperty(value = "commerce_dto")
	private Get023Dto commerceDto;

	@JsonProperty(value = "main_color")
	private String mainColor;

	@JsonProperty(value = "secondary_color")
	private String secondaryColor;

	@JsonProperty(value = "logo1")
	private byte[] logo1;

	@JsonProperty(value = "logo2")
	private byte[] logo2;

	@JsonProperty(value = "background_image")
	private byte[] backgroundImage;

	@JsonProperty(value = "created_at")
	private Date createdAt;

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "date_update")
	private Date dateUpdate;

	@JsonProperty(value = "user_update_id")
	private Long userUpdateId;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommerceCode() {
		return commerceCode;
	}

	public void setCommerceCode(Long commerceCode) {
		this.commerceCode = commerceCode;
	}

	public Get023Dto getCommerceDto() {
		return commerceDto;
	}

	public void setCommerceDto(Get023Dto commerceDto) {
		this.commerceDto = commerceDto;
	}

	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public byte[] getLogo1() {
		return logo1;
	}

	public void setLogo1(byte[] logo1) {
		this.logo1 = logo1;
	}

	public byte[] getLogo2() {
		return logo2;
	}

	public void setLogo2(byte[] logo2) {
		this.logo2 = logo2;
	}

	public byte[] getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(byte[] backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getUserUpdateId() {
		return userUpdateId;
	}

	public void setUserUpdateId(Long userUpdateId) {
		this.userUpdateId = userUpdateId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static CommerceConfigDto toDTO(CommerceConfigEntity saved) {
		CommerceConfigDto dto = new CommerceConfigDto();
		BeanUtils.copyProperties(saved, dto);
		if (Optional.ofNullable(saved.getBackgroundImage()).isPresent()) {
			dto.setBackgroundImage(saved.getBackgroundImage());
		}

		if (Optional.ofNullable(saved.getLogo1()).isPresent()) {
			dto.setLogo1(saved.getLogo1());
		}

		if (Optional.ofNullable(saved.getLogo2()).isPresent()) {
			dto.setLogo2(saved.getLogo2());
		}
		return dto;
	}

	public static List<CommerceConfigDto> toListDTO(List<CommerceConfigEntity> list) {
		List<CommerceConfigDto> response = new ArrayList<CommerceConfigDto>();
		for (CommerceConfigEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static CommerceConfigEntity toENTITY(CommerceConfigDto saved) {
		CommerceConfigEntity entity = new CommerceConfigEntity();
		BeanUtils.copyProperties(saved, entity);
		if (Optional.ofNullable(saved.getBackgroundImage()).isPresent()) {
			entity.setBackgroundImage(saved.getBackgroundImage());
		}

		if (Optional.ofNullable(saved.getLogo1()).isPresent()) {
			entity.setLogo1(saved.getLogo1());
		}

		if (Optional.ofNullable(saved.getLogo2()).isPresent()) {
			entity.setLogo2(saved.getLogo2());
		}
		return entity;
	}

	public static List<CommerceConfigEntity> toListENTITY(List<CommerceConfigDto> list) {
		List<CommerceConfigEntity> response = new ArrayList<CommerceConfigEntity>();
		for (CommerceConfigDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "CommerceConfigDto [id=" + id + ", commerceCode=" + commerceCode + ", commerceDto=" + commerceDto
				+ ", mainColor=" + mainColor + ", secondaryColor=" + secondaryColor + ", createdAt=" + createdAt
				+ ", status=" + status + ", dateUpdate=" + dateUpdate + ", userUpdateId=" + userUpdateId
				+ ", additionalProperties=" + additionalProperties + "]";
	}
}