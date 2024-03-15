package py.com.adetsa.exception;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import py.com.adetsa.mapper.OrikaBeanMapper;
import py.com.adetsa.response.LotteryBaseResponse;

@ControllerAdvice
public class LotteryExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(LotteryExceptionHandler.class);

	private static Map<String, HttpStatus> posibleStatus = new TreeMap<String, HttpStatus>();
	private static HttpHeaders responseHeaders = new HttpHeaders();
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	private LotteryExceptionHandler() {
		super();
	}

	static {
		posibleStatus.put(LotteryInvocationException.TX_NOTFOUND, HttpStatus.NOT_FOUND);
		posibleStatus.put(LotteryInvocationException.TX_INVALID_STATUS, HttpStatus.CONFLICT);
		posibleStatus.put(LotteryInvocationException.TX_NO_FEES, HttpStatus.CONFLICT);
		posibleStatus.put(LotteryInvocationException.TX_TIME_OUT, HttpStatus.REQUEST_TIMEOUT);
		posibleStatus.put(LotteryInvocationException.TX_NOT_REVERSED_UNMODIFIED, HttpStatus.NOT_MODIFIED);
		posibleStatus.put(LotteryInvocationException.TX_NO_INVOICE, HttpStatus.NOT_FOUND);

		responseHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	}
	
	@ExceptionHandler(LotteryApplicationException.class)
	public ResponseEntity<LotteryBaseResponse> handlerError(LotteryApplicationException e) {
		logger.error("#handlerError - LotteryExceptionHandler: {}", e.getMessage());
		LotteryBaseResponse response = mapper.map(e, LotteryBaseResponse.class);
		HttpStatus status = HttpStatus.CONFLICT;
		String errorCode = e.getMessage(); //e.getErrorCode();

		if (posibleStatus.containsKey(errorCode)) {
			status = posibleStatus.get(errorCode);
		} else {
			logger.warn("Unable to translate {}: {}", LotteryApplicationException.class.getName(), e);
		}
		
		logger.error("#handlerError - Response: {}", response);
		return new ResponseEntity<LotteryBaseResponse>(response, responseHeaders, status);
	}
}
