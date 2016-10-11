package model;

public interface ICard {
	boolean isConnected();
	void setConnection(boolean v);
	void setValidation(boolean v);
	boolean isValid();
	boolean checkSecretCode(int code);
}
