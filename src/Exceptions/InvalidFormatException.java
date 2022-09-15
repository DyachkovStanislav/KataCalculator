package Exceptions;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException() {

    }

    public InvalidFormatException(String message) {
        super(message);
    }
}
