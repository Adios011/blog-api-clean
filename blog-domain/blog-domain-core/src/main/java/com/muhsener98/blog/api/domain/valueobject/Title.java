package com.muhsener98.blog.api.domain.valueobject;

import java.util.Objects;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notBlank;


public class Title {

    private final String value;

    public Title(String value) {
        this.value = notBlank(value, "title value cannot be null or blank");
    }


    public boolean isValid(){
        return value.length() >= 5;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(value, title.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
