package com.muhsener98.blog.api.domain.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String domainName, String searchKey, Object value) {
        super("%s not found with provided %s : %s".formatted(domainName , searchKey , value));
    }
}
