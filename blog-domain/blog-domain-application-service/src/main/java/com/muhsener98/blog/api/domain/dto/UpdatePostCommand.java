package com.muhsener98.blog.api.domain.dto;

import com.muhsener98.blog.api.domain.valueobject.PostTag;

import java.util.*;


public class UpdatePostCommand {

    private UUID id;
    private String title;
    private String content ;
    private String category;
    private List<String> tags ;

    public UpdatePostCommand(UUID id, String title, String content, String category, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }
}
