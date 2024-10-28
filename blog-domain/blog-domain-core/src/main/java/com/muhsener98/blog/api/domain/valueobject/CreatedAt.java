package com.muhsener98.blog.api.domain.valueobject;

import java.util.Date;
import java.util.Objects;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public class CreatedAt {

    private Date value;

    private CreatedAt(Date value) {
        this.value = value;
    }

    public static CreatedAt now() {
        return new CreatedAt(new Date());
    }

    public static CreatedAt of(Date value) {
        return new CreatedAt(notNull(value , "created-at value cannot be null"));
    }


    public Date getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedAt createdAt = (CreatedAt) o;
        return Objects.equals(value, createdAt.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
