package com.muhsener98.blog.api.domain.port.security;

public class InsufficientPrivilegesException extends SecurityError{

    public InsufficientPrivilegesException(String missingRole) {
        super("Access denied: User must have  role: %s".formatted(missingRole));
    }


}
