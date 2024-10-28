package com.muhsener98.blog.api.domain.port.security;

import com.muhsener98.blog.api.domain.entity.Post;

import java.util.UUID;

public interface SecurityOutputPort {

    default void assertThatUserHasRole(String role){
        if(!hasRole(role))
            throw new InsufficientPrivilegesException(role);

    }


    boolean hasRole(String role);
    UUID currentUserId();

    default void assertThatUserHasPermissionToUpdate(Post postToBeUpdated){
        if(hasRole("ADMIN"))
            return;

        if(currentUserId() != postToBeUpdated.getAuthorId().getValue()){
            throw new InsufficientPrivilegesException("ADMIN");
        }

    }
}
