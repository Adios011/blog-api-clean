package com.muhsener98.blog.api.domain.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidDomainException extends DomainException{

    private final List<ValidationError> validationErrors ;

    public InvalidDomainException(String domainName, List<ValidationError> validationErrors) {
        super(domainName);
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }
}
