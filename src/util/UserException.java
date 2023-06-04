package util;

public class UserException extends Exception {


	public UserException() {
		super("Password Invalido");
	}

	public UserException(String message) {
		super(message);
	}

	
}
