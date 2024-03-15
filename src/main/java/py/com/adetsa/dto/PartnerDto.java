package py.com.adetsa.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import py.com.adetsa.db.domain.PartnerEntity;

public class PartnerDto {
	public Long id;
	public String partnerCod;
	public String partnerName;
	public String ruc;
	public String voto;
	public String status;

	public String partnerCodVoto;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public PartnerDto() {
		super();
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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartnerCodVoto() {
		return partnerCodVoto;
	}

	public void setPartnerCodVoto(String partnerCodVoto) {
		this.partnerCodVoto = partnerCodVoto;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static PartnerDto toDTO(PartnerEntity saved) {
		PartnerDto dto = new PartnerDto();
		BeanUtils.copyProperties(saved, dto);
		return dto;
	}

	public static List<PartnerDto> toListDTO(List<PartnerEntity> list) {
		List<PartnerDto> response = new ArrayList<PartnerDto>();
		for (PartnerEntity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static PartnerEntity toENTITY(PartnerDto saved) {
		PartnerEntity entity = new PartnerEntity();
		BeanUtils.copyProperties(saved, entity);
		return entity;
	}

	public static List<PartnerEntity> toListENTITY(List<PartnerDto> list) {
		List<PartnerEntity> response = new ArrayList<PartnerEntity>();
		for (PartnerDto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "PartnerDto [id=" + id + ", partnerCod=" + partnerCod + ", partnerName=" + partnerName + ", ruc=" + ruc
				+ ", voto=" + voto + ", status=" + status + ", partnerCodVoto=" + partnerCodVoto
				+ ", additionalProperties=" + additionalProperties + "]";
	}
}