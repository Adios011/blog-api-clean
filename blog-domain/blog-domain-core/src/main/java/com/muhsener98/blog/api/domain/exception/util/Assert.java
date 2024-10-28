package com.muhsener98.blog.api.domain.exception.util;

public class Assert {

    public static <T> T notNull(T something){
        if(something == null)
            throw new IllegalArgumentException("null value!");
        return something;
    }

    public static <T> T notNull(T something, String message){
        if(something == null)
            throw new IllegalArgumentException(message);

        return something;
    }

    public static String notBlank(String something){
        if(notNull(something).isEmpty() || something.isBlank()){
            throw new IllegalArgumentException("empty or blank string!");
        }

        return something;
    }

    public static String notBlank(String something, String message){
        if(notNull(something,message).isEmpty() || something.isBlank()){
            throw new IllegalArgumentException(message);
        }

        return something;
    }

}
