package py.com.adetsa.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wordnik.swagger.annotations.ApiModelProperty;

import py.com.adetsa.exception.GenericMessageKey;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "status", "error_code", "message" })
public class LotteryBaseResponse {

	@JsonProperty(value = "status")
	private boolean status;

	@JsonProperty(value = "error_code")
	private String errorCode;

	@JsonProperty(value = "message")
	private String message;
	
	public LotteryBaseResponse() {
		super();
	}

	public LotteryBaseResponse(boolean success, String errorCode, String message) {
		super();
		this.status = success;
		this.errorCode = errorCode;
		this.message = message;
	}

	public LotteryBaseResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public LotteryBaseResponse(GenericMessageKey genericMsg) {
		super();
		this.message = genericMsg.getDesc();
		this.status = levelToStatus(genericMsg.getLevel());
		this.errorCode = genericMsg.getKey();
	}

	public static boolean levelToStatus(String level) {
		if (GenericMessageKey.success().equals(level)) {
			return true;
		}
		return false;
	}

	/**
	 * Detalle de la respuesta
	 *
	 * @return message
	 */
	@ApiModelProperty(notes = "detalle de respuesta")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Indicador de respuesta
	 *
	 * @return status
	 */
	@ApiModelProperty(notes = "indicador de resultado")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Código de error
	 *
	 * @return errorCode
	 */
	@ApiModelProperty(notes = "código de error")
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "LotteryBaseResponse [status=" + status + ", errorCode=" + errorCode + ", message=" + message + "]";
	}
}