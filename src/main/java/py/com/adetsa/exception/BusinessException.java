package py.com.adetsa.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import py.com.adetsa.util.LotteryUtils;

public abstract class BusinessException extends Exception {

	public enum FIELDS_POSSIBLE_ERRORS {
		REQUIRED, INVALID, DUPLICATE
	}

	private static final long serialVersionUID = 8943855572101122016L;

	@JsonProperty(value = "error_code")
	private final String errorCode;

	@JsonProperty(value = "offending_field")
	protected String offendingField;
	
	@JsonProperty(value = "field_error_type")
	public FIELDS_POSSIBLE_ERRORS fieldErrorType;

	public BusinessException(GenericMessageKey msgKey, String msg) {
		super(msg);
		errorCode = msgKey.getKey();
	}

	public BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.offendingField = null;
		this.fieldErrorType = null;
	}

	public BusinessException(String errorCode, String message, String offendingField) {
		super(message);
		this.errorCode = errorCode;
		this.offendingField = offendingField;
		this.fieldErrorType = null;
	}

	public BusinessException(String errorCode, String message, String offendingField,
			FIELDS_POSSIBLE_ERRORS fieldErrorType) {
		super(message);
		this.errorCode = errorCode;
		this.offendingField = offendingField;
		this.fieldErrorType = fieldErrorType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		String message = super.getMessage();
		if (message != null) {
			return message;
		}
		if (offendingField != null) {
			if (fieldErrorType != null && fieldErrorType.equals(FIELDS_POSSIBLE_ERRORS.REQUIRED)) {
				return "The field " + LotteryUtils.formatLogString(offendingField) + " is required";
			} else {
				if (fieldErrorType != null && fieldErrorType.equals(FIELDS_POSSIBLE_ERRORS.DUPLICATE)) {
					return "The field " + LotteryUtils.formatLogString(offendingField) + " is duplicate";
				} else {
					return "The field " + LotteryUtils.formatLogString(offendingField) + " is invalid";
				}
			}
		}
		return null;
	}

	public String getOffendingField() {
		return offendingField;
	}

	public FIELDS_POSSIBLE_ERRORS getFieldErrorType() {
		return fieldErrorType;
	}

	@Override
	public String toString() {
		return "BusinessException [errorCode=" + errorCode + ", offendingField=" + offendingField + ", fieldErrorType="
				+ fieldErrorType + "]";
	}
}
