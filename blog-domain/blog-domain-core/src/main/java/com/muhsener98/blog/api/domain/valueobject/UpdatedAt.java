package com.muhsener98.blog.api.domain.valueobject;

import java.util.Date;
import java.util.Objects;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public class UpdatedAt {

    private Date value;

    private  UpdatedAt(Date value) {
        this.value = value;
    }

    public static UpdatedAt now(){
        return new UpdatedAt(new Date());
    }

    public static UpdatedAt of(Date value){
        return new UpdatedAt(notNull(value));
    }


    public Date getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatedAt updatedAt = (UpdatedAt) o;
        return Objects.equals(value, updatedAt.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
