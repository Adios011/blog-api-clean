package com.muhsener98.blog.api.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<ID> {

    private final ID value;

    public BaseId(ID value) {
        this.value = value;
    }

    public ID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(value, baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
