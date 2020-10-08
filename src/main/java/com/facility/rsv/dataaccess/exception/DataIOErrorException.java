package com.facility.rsv.dataaccess.exception;
public class DataIOErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataIOErrorException() {
        super();
    }

    public DataIOErrorException(String message) {
        super(message);
    }

    public DataIOErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIOErrorException(Throwable cause) {
        super(cause);
    }

}