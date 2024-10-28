package com.muhsener98.blog.api.domain.port.dataaccess;

public class PersistenceException extends RuntimeException{

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
