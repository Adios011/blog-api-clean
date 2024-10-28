package com.muhsener98.blog.api.domain.exception;

public  abstract class DomainException extends RuntimeException{

    private final String domainName;

    public DomainException(String domainName) {
        super("Error in domain: " + domainName);
        this.domainName = domainName;
    }


    public String getDomainName() {
        return domainName;
    }
}
