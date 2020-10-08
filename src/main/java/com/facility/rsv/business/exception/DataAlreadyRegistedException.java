package com.facility.rsv.business.exception;

public class DataAlreadyRegistedException extends Exception{
      private static final long serialVersionUID = 1L;

        public DataAlreadyRegistedException() {
            super();
        }

        public DataAlreadyRegistedException(String message) {
            super(message);
        }

        public DataAlreadyRegistedException(String message, Throwable cause) {
            super(message, cause);
        }

        public DataAlreadyRegistedException(Throwable cause) {
            super(cause);
        }
}
