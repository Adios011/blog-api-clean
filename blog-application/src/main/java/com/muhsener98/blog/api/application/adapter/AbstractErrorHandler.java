package com.muhsener98.blog.api.application.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractErrorHandler {

    public void logError(Exception e){
        log.error(e.getMessage() , e);
    }
}
