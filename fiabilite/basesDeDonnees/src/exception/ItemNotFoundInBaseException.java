package exception;

public class ItemNotFoundInBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5094182162199742185L;
	public ItemNotFoundInBaseException() {
		super();
	}
	public ItemNotFoundInBaseException(String message) {
		super(message);
	}
	public ItemNotFoundInBaseException(String message, Throwable throwable) {
		super(message, throwable);
	}
	public ItemNotFoundInBaseException(Throwable throwable) {
		super(throwable);
	}

}
