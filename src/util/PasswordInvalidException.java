

package util;

public class PasswordInvalidException extends UserException {
   

	public PasswordInvalidException(){
		super("Password Invalido");
	}
    public PasswordInvalidException(String Message){
        super(Message);
    }
}

