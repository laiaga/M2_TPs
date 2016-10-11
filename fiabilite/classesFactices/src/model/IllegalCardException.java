package model;

public class IllegalCardException extends Exception {

	private static final long serialVersionUID = -8592489125391152634L;
	
	public IllegalCardException() {
		super();
	}
	public IllegalCardException(String message) {
		super(message);
	}
	public IllegalCardException(String message, Throwable throwable) {
		super(message, throwable);
	}
	public IllegalCardException(Throwable throwable) {
		super(throwable);
	}
}