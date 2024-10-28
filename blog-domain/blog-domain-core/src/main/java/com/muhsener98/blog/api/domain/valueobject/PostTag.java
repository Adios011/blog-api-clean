package com.muhsener98.blog.api.domain.valueobject;

import java.util.Objects;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notBlank;

public class PostTag {

    private String val;

    private PostTag(String val) {
        this.val = val;
    }

    public static PostTag of(String val) {
        return new PostTag(notBlank(val, "Post-tag value cannot be null or blank"));
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    //TODO: delete this rule
    public boolean isValid() {
        return val.length() > 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag postTag = (PostTag) o;
        return Objects.equals(val, postTag.val);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }
}
