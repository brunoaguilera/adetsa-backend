package py.com.adetsa.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import py.com.adetsa.db.domain.Get023Entity;
import py.com.adetsa.validate.CommerceValidate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ge23clicod", "ge23clinom", "ge45ticcli", "ge25ecogru", "ge23pjid", "ge23cliruc", "ge23ultsuc",
		"ge23rubid", "ge23mercod", "ge23agrext", "ge23fhoupd", "ge23usuupd" })
public class Get023Dto implements Serializable {
	private static final long serialVersionUID = 7261236819626502760L;

	@JsonProperty(value = "ge23clicod")
	private Long ge23clicod;

	@JsonProperty(value = "ge23clinom")
	private String ge23clinom;

	@JsonProperty(value = "ge23fhoupd")
	private Date ge23fhoupd;

	@JsonProperty(value = "ge23usuupd")
	private String ge23usuupd;

	@JsonProperty(value = "ge45ticcli")
	private String ge45ticcli;

	@JsonProperty(value = "ge25ecogru")
	private String ge25ecogru;

	@JsonProperty(value = "ge23pjid")
	private Integer ge23pjid;

	@JsonProperty(value = "ge23cliruc")
	private String ge23cliruc;

	@JsonProperty(value = "ge23ultsuc")
	private Integer ge23ultsuc;

	@JsonProperty(value = "ge23rubid")
	private Integer ge23rubid;

	@JsonProperty(value = "ge23mercod")
	private Integer ge23mercod;

	@JsonProperty(value = "ge23agrext")
	private String ge23agrext;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Long getGe23clicod() {
		return ge23clicod;
	}

	public void setGe23clicod(Long ge23clicod) {
		this.ge23clicod = ge23clicod;
	}

	public String getGe23clinom() {
		return ge23clinom;
	}

	public void setGe23clinom(String ge23clinom) {
		this.ge23clinom = ge23clinom;
	}

	public Date getGe23fhoupd() {
		return ge23fhoupd;
	}

	public void setGe23fhoupd(Date ge23fhoupd) {
		this.ge23fhoupd = ge23fhoupd;
	}

	public String getGe23usuupd() {
		return ge23usuupd;
	}

	public void setGe23usuupd(String ge23usuupd) {
		this.ge23usuupd = ge23usuupd;
	}

	public String getGe45ticcli() {
		return ge45ticcli;
	}

	public void setGe45ticcli(String ge45ticcli) {
		this.ge45ticcli = ge45ticcli;
	}

	public String getGe25ecogru() {
		return ge25ecogru;
	}

	public void setGe25ecogru(String ge25ecogru) {
		this.ge25ecogru = ge25ecogru;
	}

	public Integer getGe23pjid() {
		return ge23pjid;
	}

	public void setGe23pjid(Integer ge23pjid) {
		this.ge23pjid = ge23pjid;
	}

	public String getGe23cliruc() {
		return ge23cliruc;
	}

	public void setGe23cliruc(String ge23cliruc) {
		this.ge23cliruc = ge23cliruc;
	}

	public Integer getGe23ultsuc() {
		return ge23ultsuc;
	}

	public void setGe23ultsuc(Integer ge23ultsuc) {
		this.ge23ultsuc = ge23ultsuc;
	}

	public Integer getGe23rubid() {
		return ge23rubid;
	}

	public void setGe23rubid(Integer ge23rubid) {
		this.ge23rubid = ge23rubid;
	}

	public Integer getGe23mercod() {
		return ge23mercod;
	}

	public void setGe23mercod(Integer ge23mercod) {
		this.ge23mercod = ge23mercod;
	}

	public String getGe23agrext() {
		return ge23agrext;
	}

	public void setGe23agrext(String ge23agrext) {
		this.ge23agrext = ge23agrext;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public static Get023Dto toDTO(Get023Entity entity) {
		CommerceValidate.entityToDtoValidateGet023(entity);
		Get023Dto dto = new Get023Dto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static List<Get023Dto> toListDTO(List<Get023Entity> list) {
		List<Get023Dto> response = new ArrayList<Get023Dto>();
		for (Get023Entity entity : list) {
			response.add(toDTO(entity));
		}
		return response;
	}

	public static Get023Entity toENTITY(Get023Dto dto) {
		Get023Entity entity = new Get023Entity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public static List<Get023Entity> toListENTITY(List<Get023Dto> list) {
		List<Get023Entity> response = new ArrayList<Get023Entity>();
		for (Get023Dto dto : list) {
			response.add(toENTITY(dto));
		}
		return response;
	}

	@Override
	public String toString() {
		return "Get023Dto [ge23clicod=" + ge23clicod + ", ge23clinom=" + ge23clinom + ", ge23fhoupd=" + ge23fhoupd
				+ ", ge23usuupd=" + ge23usuupd + ", ge45ticcli=" + ge45ticcli + ", ge25ecogru=" + ge25ecogru
				+ ", ge23pjid=" + ge23pjid + ", ge23cliruc=" + ge23cliruc + ", ge23ultsuc=" + ge23ultsuc
				+ ", ge23rubid=" + ge23rubid + ", ge23mercod=" + ge23mercod + ", ge23agrext=" + ge23agrext
				+ ", additionalProperties=" + additionalProperties + "]";
	}
}