package py.com.adetsa.exception;

import py.com.adetsa.util.LotteryUtils;

public enum GenericMessageKey {

	SUCCESSFULL_INVOCATION("SuccessfulInvocation", success(), "INVOCACION SATISFACTORIA"),
	
	QUERY_PROCESSED("QueryProcessed", success(), "LA CONSULTA FUE PROCESADA CON EXITO"), 
	QUERY_NOT_ALLOWED("QueryNotAllowed", error(), "LA OPERACION DE CONSULTA NO ESTA PERMITIDA"), 
	QUERY_NOT_PROCESSED("QueryNotProcessed", error(), "LA CONSULTA NO FUE PROCESADA"),
	
	INSERT_PROCESSED("InsertProcessed", success(), "LA INSERCION FUE PROCESADA CON EXITO"),
	INSERT_NOT_PROCESSED("InsertNotProcessed", error(), "LA INSERCION NO PUDO SER PROCESADA"),
	INSERT_NOT_ALLOWED("InsertNotAllowed", error(), "LA OPERACION DE INSERCION NO ESTA PERMITIDA"),
	
	ERROR_UNIQUE_KEY_VALIDATE("UniqueKeyValidate", error(), "CONTROL DE REGISTRO ÚNICO - EL REGISTRO YA EXISTE, FAVOR MODIFICAR"),
	ERROR_NULL_VALUE("NullValueValidate", error(), "ATRIBUTO NO PUEDE SER NULO"),
	
	LOGIN_PROCESSED("LoginProcessed", success(), "EL LOGIN FUE REALIZADO CON EXITO"),
	
	UPDATE_PROCESSED("UpdateProcessed", success(), "LA ACTUALIZACION FUE PROCESADA CON EXITO"),
	UPDATE_NOT_PROCESSED("UpdateNotProcessed", error(), "LA ACTUALIZACION NO PUDO SER PROCESADA"),
	UPDATE_NOT_ALLOWED("UpdateNotAllowed", error(), "LA OPERACION DE ACTUALIZACION NO ESTA PERMITIDA"),
	
	DELETE_PROCESSED("DeleteProcessed", success(), "LA ELIMINACION FUE PROCESADA CON EXITO"),
	DELETE_NOT_PROCESSED("DeleteNotProcessed", error(), "LA ELIMINACION NO PUDO SER PROCESADA"),
	DELETE_NOT_FOUND("DeleteNotFound", error(), "NO SE HA ENCONTRADO EL REGISTRO A SER ELIMINADO"),
	DELETE_NOT_ALLOWED("DeleteNotAllowed", error(), "LA OPERACION DE ELIMINACION NO ESTA PERMITIDA"),

	INVALID_PARAMETERS("InvalidParameters", error(), "ERROR EN LOS PARAMETROS"), 
	INVALID_BODY("InvalidBody", error(), "ERROR EN EL CUERPO DEL MENSAJE HTTP"),
	INVALID_ARGUMENT("InvalidArgument", error(), "ERROR EN LOS ARGUMENTOS HTTP"),
	MISSING_PARAMETERS("MissingParameters", error(), "PARAMETRO REQUERIDO NO RECIBIDO"),
	FATAL_EXTERNAL_SYSTEM("FatalExternalSystem", error(), "ERROR EN LOS SISTEMAS EXTERNOS"),
	NO_RESPONSE_FROM_HOST("NoResponseFromHost", error(), "NO HUBO RESPUESTA DEL HOST/AUTORIZADOR"), 
	HOST_TRANSACTION_ERROR("HostTransactionError", error(), "ERROR EN EL HOST AUTORIZADOR"), 
	CLIENT_CONNECTION_ERROR("ClientConnectionError", error(), "NO SE PUDO ESTABLECER UNA CONEXION CON EL FACTURADOR"),  
    SERVICE_UPDATE_SUCCESS("ServiceUpdateSuccess", success(), "SERVICIO ACTUALIZADO CORRECTAMENTE"), 
	SERVICE_CREATE_SUCCESS("ServiceCreateSuccess", success(), "SERVICIO CREADO CORRECTAMENTE"),
	SERVICE_NOT_FOUND("ServiceNotFound", error(), "SERVICIO NO ENCONTRADO"),
	
	TICKET_NOT_FOUND("TicketNotFound", error(), "NUMERO DE BOLETA NO ENCONTRADO, FAVOR VUELVA A INTENTAR"),
	TICKET_NOT_VALID("TicketNotValid", error(), "NUMERO DE BOLETA NO ES UNA TRANSACCION VALIDA, FAVOR VUELVA A INTENTAR"),
	AMOUNT_NOT_MATCH("AmountNotMatch", error(), "EL IMPORTE INTRODUCIDO NO CORRESPONDE AL DE LA BOLETA"),
	PARAMETERS_NOT_FOUND("ParameterNotFound", error(), "PARAMETRO OBLIGATORIO NO ENCONTRADO"),
	NO_ACTIVE_PROMOTIONS_AT_MOMENT("NoActiveLotteryAtMoment", error(), "NO EXISTEN PROMOCIONES ACTIVAS EN ESTE MOMENTO PARA ESTE COMERCIO"),
	AMOUNT_IS_LESS_CONFIG_OF_THIS_PROMOTION("AmountIsLess", error(), "EL IMPORTE DE LA TRANSACCION ES MENOR A LA CONFIGURACION DE ESTA PROMOCION"),
	AMOUNT_IS_GREATER_CONFIG_OF_THIS_PROMOTION("AmountIsGreater", error(), "EL IMPORTE DE LA TRANSACCION ES MAYOR A LA CONFIGURACION DE ESTA PROMOCION"),
	TICKET_HAS_PARTICIPATED("TicketHasParticipatedAPromotion", error(), "LA BOLETA YA HA PARTICIPADO DE UNA PROMOCION"),
	TICKET_HAS_REVERSED("TicketHasReversed", error(), "LA BOLETA SE ENCUENTRA REVERSADA"),
	
	CHANNEL_NOT_CONFIGURED("ChannelNotConfigured", error(), "EL CANAL DE LA TRANSACCION NO SE ENCUENTRA CONFIGURADO PARA ESTA PROMOCION"),
	PAYMENT_METHOD_NOT_CONFIGURED("PaymentMethodNotConfigured", error(), "EL MEDIO DE PAGO DE LA TRANSACCION NO SE ENCUENTRA CONFIGURADO PARA ESTA PROMOCION"),
	LOTTERY_NO_STOCK("LotteryNoStock", error(), "LA PROMOCION YA NO CUENTA CON STOCK"),
	LOTTERY_PROSPECT_BY_TICKET_NUMBER("LotteryProspectByTicketNumber", error(), "ERROR EN LA CONSULTA DE LA BOLETA PARA EL PROCESO DE PROMOCION"),

	JSON_TRANSFORMER_ERROR("JsonTransformerError", error(), "No se pudo realizar el parser del json"),
	
	SENDER_EXCEEDED_AMOUNT_ERROR("SenderExceededAmountError", error(), "El emisor ha superado el limite mensual de acreditaciones"),
	RECIPIENT_EXCEEDED_AMOUNT_ERROR("RecipientExceededAmountError", error(), "El receptor ha superado el limite mensual de acreditaciones"),
	
	INVALID_USER_NAME_OR_PASSWORD("InvalidUserNameOrPassword", error(), "USUARIO O CONTRASEÑA INVALIDO"),

	UNKNOWN_ERROR("UnknownError", error(), "ERROR DESCONOCIDO");

	private final String key;
	private final String level;
	private final String description;

	GenericMessageKey(String value, String level, String description) {
		this.key = value;
		this.description = description;
		this.level = level;
	}

	public static GenericMessageKey fromKey(String value) {
		if (value != null) {
			for (GenericMessageKey messageKey : values()) {
				if (messageKey.key.equals(value)) {
					return messageKey;
				}
			}
		}
		return getDefault();
	}

	public static GenericMessageKey fromEnumName(String key) {
		if (key != null) {
			for (GenericMessageKey messageKey : values()) {
				if (messageKey.name().equals(key)) {
					return messageKey;
				}
			}
		}
		return getDefault();
	}

	public static GenericMessageKey getDefault() {
		return GenericMessageKey.UNKNOWN_ERROR;
	}

	public String getKey() {
		return key;
	}

	public String getLevel() {
		return level;
	}

	public String getDesc() {
		return description;
	}
	
	public static String success() {
		return LotteryUtils.LEVEL_STATUS_SUCCESS;
	}
	
	public static String error() {
		return LotteryUtils.LEVEL_STATUS_ERROR;
	}
}
