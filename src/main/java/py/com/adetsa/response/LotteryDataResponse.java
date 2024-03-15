package py.com.adetsa.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import py.com.adetsa.exception.GenericMessageKey;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "status", "error_code", "message", "data", "additionalProperties" })
public class LotteryDataResponse<T> extends LotteryBaseResponse {

	private T data;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public void byBaseResponse(LotteryBaseResponse response) {
		this.setStatus(response.isStatus());
		this.setMessage(response.getMessage());
		this.setErrorCode(response.getErrorCode());
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setOk() {
		this.setStatus(true);
		this.setMessage(GenericMessageKey.SUCCESSFULL_INVOCATION.getDesc());
	}

	public void setOk(String msg) {
		this.setStatus(true);
		this.setMessage(msg);
	}

	public void setError() {
		this.setStatus(false);
		this.setMessage(GenericMessageKey.SUCCESSFULL_INVOCATION.getDesc());
	}

	public void setError(String msg) {
		this.setStatus(false);
		this.setMessage(msg);
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
		return "LotteryDataResponse [data=" + data + ", additionalProperties=" + additionalProperties + ", toString()="
				+ super.toString() + "]";
	}

}
