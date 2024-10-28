package com.muhsener98.blog.api.domain.valueobject;

import java.util.UUID;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public class PostId extends BaseId<UUID>{

    public PostId(UUID value) {
        super(notNull(value,"PostId value cannot be null"));
    }
}
