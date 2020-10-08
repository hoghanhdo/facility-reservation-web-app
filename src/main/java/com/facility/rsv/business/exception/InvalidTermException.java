package com.facility.rsv.business.exception;

public class InvalidTermException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidTermException() {
        super();
    }

    public InvalidTermException(String message) {
        super(message);
    }

    public InvalidTermException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTermException(Throwable cause) {
        super(cause);
    }

}
