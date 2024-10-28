package com.muhsener98.blog.api.domain.usecase;

import com.muhsener98.blog.api.domain.dto.CreatePostCommand;
import com.muhsener98.blog.api.domain.dto.UpdatePostCommand;

import java.util.UUID;

public interface PostCrudInputPort {

    void createPost(CreatePostCommand command);

    void updatePost(UpdatePostCommand command);

    void deletePost(UUID id);

    void getPostById(UUID id);
}
