package pl.sda.meetup2.exception;

public class NoSuchEventException extends RuntimeException {
    public NoSuchEventException(String message) {
        super(message);
    }

    public NoSuchEventException() {
    }
}
