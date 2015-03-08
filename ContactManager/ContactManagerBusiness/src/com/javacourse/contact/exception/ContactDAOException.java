package com.javacourse.contact.exception;

public class ContactDAOException extends ContactException {
    public ContactDAOException() {
    }

    public ContactDAOException(String message) {
        super(message);
    }

    public ContactDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactDAOException(Throwable cause) {
        super(cause);
    }

}
