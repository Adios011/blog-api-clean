package com.muhsener98.blog.api.domain.dto;

import com.muhsener98.blog.api.domain.valueobject.PostCategory;
import com.muhsener98.blog.api.domain.valueobject.Title;

import java.util.List;

public class CreatePostCommand {

    private final String title;
    private final String content;
    private final String postCategory;
    private final List<String> tags;


    public CreatePostCommand(String title, String content, String postCategory, List<String> tags) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public List<String> getTags() {
        return tags;
    }
}
