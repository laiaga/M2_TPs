package exception;

public class ItemAlreadyInBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5983610218794508473L;
	public ItemAlreadyInBaseException() {
		super();
	}
	public ItemAlreadyInBaseException(String message) {
		super(message);
	}
	public ItemAlreadyInBaseException(String message, Throwable throwable) {
		super(message, throwable);
	}
	public ItemAlreadyInBaseException(Throwable throwable) {
		super(throwable);
	}
}
