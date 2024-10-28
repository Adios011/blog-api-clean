package com.muhsener98.blog.api.domain.mapper;

import com.muhsener98.blog.api.domain.dto.CreatePostCommand;
import com.muhsener98.blog.api.domain.dto.PostDto;
import com.muhsener98.blog.api.domain.dto.UpdatePostCommand;
import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.valueobject.PostCategory;
import com.muhsener98.blog.api.domain.valueobject.PostContent;
import com.muhsener98.blog.api.domain.valueobject.PostTag;
import com.muhsener98.blog.api.domain.valueobject.Title;

import java.util.stream.Collectors;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public class PostDataMapper {
    public Post toDomainEntity(CreatePostCommand command) {
        return Post.PostBuilder.builder()
                .title(new Title(command.getTitle()))
                .content(new PostContent(command.getContent()))
                .tags(command.getTags().stream().map(PostTag::of).collect(Collectors.toList()))
                .category(PostCategory.of(command.getPostCategory()))
                .build();
    }

    public PostDto toDto(Post postSaved) {
        return new PostDto(postSaved.getId().getValue(),
                postSaved.getAuthorId().getValue(),
                postSaved.getTitle().getValue(),
                postSaved.getContent().getContent(),
                postSaved.getCategory().name(),
                postSaved.getTags().stream().map(PostTag::getVal).toList(),
                postSaved.getCreatedAt().getValue(),
                postSaved.getUpdatedAt().getValue());
    }

    /**
     * Merges old values with command. If a property in command is null, then old value is mapped.
     * @param oldValues old details of Post
     * @param newValues new details of Post
     * @return merges and creates a new Post
     */
    public Post merge(Post oldValues, UpdatePostCommand newValues) {
        if (oldValues.getId() == null || newValues.getId() == null || !oldValues.getId().getValue().equals(newValues.getId()))
            throw new IllegalArgumentException("IDs do not match to merge");



        return Post.PostBuilder.builder()
                .id(oldValues.getId())
                .title(newValues.getTitle() == null ? oldValues.getTitle() : new Title(newValues.getTitle()))
                .content(newValues.getContent() == null ? oldValues.getContent() : new PostContent(newValues.getContent()))
                .category(newValues.getCategory() == null ? oldValues.getCategory() : PostCategory.of(newValues.getCategory()))
                .tags(newValues.getTags() == null ? oldValues.getTags() : newValues.getTags().stream().map(PostTag::of).toList())
                .authorId(oldValues.getAuthorId())
                .build();



    }
}
