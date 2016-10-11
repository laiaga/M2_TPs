package model;

public class NumberOfTryExceededException extends Exception {
	
	private static final long serialVersionUID = 2639879915938061574L;
	
	public NumberOfTryExceededException() {
		super();
	}
	public NumberOfTryExceededException(String message) {
		super(message);
	}
	public NumberOfTryExceededException(String message, Throwable throwable) {
		super(message, throwable);
	}
	public NumberOfTryExceededException(Throwable throwable) {
		super(throwable);
	}
}
