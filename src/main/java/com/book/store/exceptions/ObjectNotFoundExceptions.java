package com.book.store.exceptions;

public class ObjectNotFoundExceptions extends RuntimeException {

    public ObjectNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundExceptions(String cause) {
        super(cause);
    }
}
