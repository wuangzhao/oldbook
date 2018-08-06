package org.fd.exception;

/**
 * 找不到书异常
 */
public class FailureException extends RuntimeException {
    
    public FailureException(String message) {
        super(message);
    }

    public FailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
