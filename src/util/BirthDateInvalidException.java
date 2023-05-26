package util;

public class BirthDateInvalidException extends UserException {

    /**
     * 
     */
    private static final long serialVersionUID = 4081633597571256549L;

    public BirthDateInvalidException() {
        super("Data de nascimento inválida");
    }

    public BirthDateInvalidException(String message) {
        super(message);
    }
}