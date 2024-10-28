package com.muhsener98.blog.api.application.controller;

import com.muhsener98.blog.api.application.model.CreatePostRequest;
import com.muhsener98.blog.api.application.model.UpdatePostRequest;
import com.muhsener98.blog.api.domain.dto.CreatePostCommand;
import com.muhsener98.blog.api.domain.dto.UpdatePostCommand;
import com.muhsener98.blog.api.domain.usecase.PostCrudInputPort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("posts")
public class PostController {

    private final PostCrudInputPort postCrudInputPort;

    public PostController(PostCrudInputPort postCrudInputPort) {
        this.postCrudInputPort = postCrudInputPort;
    }

    @PostMapping
    public void createPost(@Valid @RequestBody CreatePostRequest request) {
        CreatePostCommand command =
                new CreatePostCommand(request.getTitle(), request.getContent(), request.getCategory(), request.getTags());
        postCrudInputPort.createPost(command);
    }


    @PutMapping("{postId}")
    public void updatePost(@PathVariable UUID postId, @Valid @RequestBody UpdatePostRequest request) {
        UpdatePostCommand command = new UpdatePostCommand(postId , request.getTitle(), request.getContent(), request.getCategory(), request.getTags());
        postCrudInputPort.updatePost(command);
    }

    @GetMapping("{postId}")
    public void getPost(@PathVariable UUID postId) {
        postCrudInputPort.getPostById(postId);
    }




    @DeleteMapping("{postId}")
    public void deletePost(@PathVariable UUID postId) {
        postCrudInputPort.deletePost(postId);
    }



}
