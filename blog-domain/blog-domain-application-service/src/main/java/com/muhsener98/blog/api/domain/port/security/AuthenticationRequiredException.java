package com.muhsener98.blog.api.domain.port.security;

public class AuthenticationRequiredException extends SecurityError {


    public AuthenticationRequiredException() {
    }

    public AuthenticationRequiredException(String message) {
        super("user is not authenticated!");
    }
}
