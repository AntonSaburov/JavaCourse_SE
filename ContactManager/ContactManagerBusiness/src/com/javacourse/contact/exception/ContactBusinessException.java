package com.javacourse.contact.exception;

public class ContactBusinessException extends ContactException
{
    public ContactBusinessException() {
    }

    public ContactBusinessException(String message) {
        super(message);
    }

    public ContactBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactBusinessException(Throwable cause) {
        super(cause);
    }

    public ContactBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
