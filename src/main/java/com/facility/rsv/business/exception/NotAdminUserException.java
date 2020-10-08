package com.facility.rsv.business.exception;

public class NotAdminUserException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotAdminUserException() {
        super();
    }

    public NotAdminUserException(String message) {
        super(message);
    }

    public NotAdminUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAdminUserException(Throwable cause) {
        super(cause);
    }

}