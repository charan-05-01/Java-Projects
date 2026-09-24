package projects.atm.exceptions;

public class InvalidMobileException extends RuntimeException {
    public InvalidMobileException(String message) {
        super(message);
    }
}
