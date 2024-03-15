package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import py.com.adetsa.db.domain.PartnerCandidatosEntity;

public class PartnerCandidatosDto {
	public String partnerCod;
	public PartnerDto partner;
	public Long cantidadVotos;

	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
	}

	public PartnerDto getPartner() {
		return partner;
	}

	public void setPartner(PartnerDto partner) {
		this.partner = partner;
	}

	public Long getCantidadVotos() {
		return cantidadVotos;
	}

	public void setCantidadVotos(Long cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public PartnerCandidatosDto() {
		super();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static PartnerCandidatosDto toDTO(PartnerCandidatosEntity saved) {
		PartnerCandidatosDto dto = new PartnerCandidatosDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<PartnerCandidatosDto> toListDTO(List<PartnerCandidatosEntity> list) {
		List<PartnerCandidatosDto> response = new ArrayList<PartnerCandidatosDto>();
		for (PartnerCandidatosEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static PartnerCandidatosEntity toENTITY(PartnerCandidatosDto saved) {
		PartnerCandidatosEntity entity = new PartnerCandidatosEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<PartnerCandidatosEntity> toListENTITY(List<PartnerCandidatosDto> list) {
		List<PartnerCandidatosEntity> response = new ArrayList<PartnerCandidatosEntity>();
		for (PartnerCandidatosDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "PartnerCandidatosDto [partnerCod=" + partnerCod + ", partner=" + partner + ", cantidadVotos="
				+ cantidadVotos + ", additionalProperties=" + additionalProperties + "]";
	}

}