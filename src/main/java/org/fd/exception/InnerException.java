package org.fd.exception;

/**
 * 预约业务异常
 */
public class InnerException extends RuntimeException{

    public InnerException(String message) {
        super(message);
    }

    public InnerException(String message, Throwable cause) {
        super(message, cause);
    }
}
