package com.muhsener98.blog.api.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdatePostRequest {

    private String title;
    private String content;
    private String category;
    private List<String> tags;

}
