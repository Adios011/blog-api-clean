package com.muhsener98.blog.api.domain.valueobject;

import java.util.Objects;

import static com.muhsener98.blog.api.domain.exception.util.Assert.*;

public class PostContent {

    private final String content ;
    private final int length;

    public PostContent(String content) {
        this.content = notBlank(content, "post content cannot be null or blank");
        this.length = content.length();
    }

    public String getContent() {
        return content;
    }

    public int getLength() {
        return length;
    }

    //TODO: Imaginary validation rule
    public boolean isValid(){
        return length >= 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostContent that = (PostContent) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content);
    }
}
