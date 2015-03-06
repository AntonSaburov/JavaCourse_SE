package com.javacourse.contact.exception;

public class ContactDAOException extends ContactException
{
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

    public ContactDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
