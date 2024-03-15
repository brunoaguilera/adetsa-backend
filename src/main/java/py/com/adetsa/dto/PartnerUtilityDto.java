package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import py.com.adetsa.db.domain.PartnerUtilityEntity;

public class PartnerUtilityDto {
	public Long id;
	public String partnerCod;
	public String partnerName;
	public double utility;
	public String withdrawMoney;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public PartnerUtilityDto() {
		super();
	}

	public PartnerUtilityDto(String partnerCod, String partnerName, double utility) {
		super();
		this.partnerCod = partnerCod;
		this.partnerName = partnerName;
		this.utility = utility;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public double getUtility() {
		return utility;
	}

	public void setUtility(double utility) {
		this.utility = utility;
	}

	public String getWithdrawMoney() {
		return withdrawMoney;
	}

	public void setWithdrawMoney(String withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static PartnerUtilityDto toDTO(PartnerUtilityEntity saved) {
		PartnerUtilityDto dto = new PartnerUtilityDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<PartnerUtilityDto> toListDTO(List<PartnerUtilityEntity> list) {
		List<PartnerUtilityDto> response = new ArrayList<PartnerUtilityDto>();
		for (PartnerUtilityEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static PartnerUtilityEntity toENTITY(PartnerUtilityDto saved) {
		PartnerUtilityEntity entity = new PartnerUtilityEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<PartnerUtilityEntity> toListENTITY(List<PartnerUtilityDto> list) {
		List<PartnerUtilityEntity> response = new ArrayList<PartnerUtilityEntity>();
		for (PartnerUtilityDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "PartnerUtilityDto [id=" + id + ", partnerCod=" + partnerCod + ", partnerName=" + partnerName
				+ ", utility=" + utility + ", withdrawMoney=" + withdrawMoney + ", additionalProperties="
				+ additionalProperties + "]";
	}
}