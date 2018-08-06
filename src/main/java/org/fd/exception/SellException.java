package org.fd.exception;

/**
 * 预约业务异常
 */
public class SellException extends RuntimeException{

    public SellException(String message) {
        super(message);
    }

    public SellException(String message, Throwable cause) {
        super(message, cause);
    }
}
