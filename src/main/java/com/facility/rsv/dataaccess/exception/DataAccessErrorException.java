package com.facility.rsv.dataaccess.exception;


public class DataAccessErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataAccessErrorException() {
        super();
    }

    public DataAccessErrorException(String message) {
        super(message);
    }

    public DataAccessErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessErrorException(Throwable cause) {
        super(cause);
    }

}
