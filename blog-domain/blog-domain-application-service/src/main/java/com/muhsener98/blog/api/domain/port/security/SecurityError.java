package com.muhsener98.blog.api.domain.port.security;

public class SecurityError extends RuntimeException{

    public SecurityError() {
    }

    public SecurityError(String message) {
        super(message);
    }
}
