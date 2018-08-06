package org.fd.exception;

public class IllegalException extends RuntimeException {

    public IllegalException(String message) {
        super(message);
    }

    public IllegalException(String message, Throwable cause) {
        super(message, cause);
    }
}
