package com.facility.rsv.business.exception;
public class SystemErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public SystemErrorException() {
        super();
    }

    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemErrorException(Throwable cause) {
        super(cause);
    }

}
