package Exceptions;

public class RomanNegativeNumberException extends RuntimeException {
    public RomanNegativeNumberException() {
    }

    public RomanNegativeNumberException(String message) {
        super(message);
    }
}
