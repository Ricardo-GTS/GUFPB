package util;

public class BirthDateInvalidException extends UserException {


    public BirthDateInvalidException() {
        super("Data de nascimento inválida");
    }

    public BirthDateInvalidException(String message) {
        super(message);
    }
}