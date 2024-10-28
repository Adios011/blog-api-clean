package com.muhsener98.blog.api.domain.valueobject;

import java.util.UUID;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public class AuthorId extends BaseId<UUID> {

    public AuthorId(UUID value) {
        super(notNull(value , "AuthorId value cannot be null"));
    }
}
