package py.com.adetsa.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActualizaSocioVotoRequest {
	public String partnerCod;
	public String partnerCodVoto;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public String getPartnerCod() {
		return partnerCod;
	}

	public void setPartnerCod(String partnerCod) {
		this.partnerCod = partnerCod;
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

	@Override
	public String toString() {
		return "ActualizaSocioVotoRequest [partnerCod=" + partnerCod + ", partnerCodVoto=" + partnerCodVoto
				+ ", additionalProperties=" + additionalProperties + "]";
	}
}