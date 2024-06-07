package hust.soict.ict.aims.exception;

public class PlayerException extends Exception {
    public PlayerException() {
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

}
