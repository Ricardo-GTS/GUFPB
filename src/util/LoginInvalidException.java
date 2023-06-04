

package util;


public class LoginInvalidException extends UserException {
   
	

	public LoginInvalidException(){
    	super("Login invalido");
    }
   
    public LoginInvalidException(String Message){
        super(Message);
    }
}

