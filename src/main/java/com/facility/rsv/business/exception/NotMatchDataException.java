package com.facility.rsv.business.exception;


public class NotMatchDataException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotMatchDataException() {
        super();
    }

    public NotMatchDataException(String message) {
        super(message);
    }

    public NotMatchDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotMatchDataException(Throwable cause) {
        super(cause);
    }

}
