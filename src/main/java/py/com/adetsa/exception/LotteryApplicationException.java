package py.com.adetsa.exception;

public class LotteryApplicationException extends BusinessException {

	private static final long serialVersionUID = 5029508179517400869L;

	public LotteryApplicationException(String message) {
		super(GenericMessageKey.UNKNOWN_ERROR.getKey(), message);
	}

	public LotteryApplicationException(Throwable e) {
		super(GenericMessageKey.UNKNOWN_ERROR.getKey(), e.getMessage());
	}
}
