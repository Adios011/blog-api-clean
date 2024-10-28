package com.muhsener98.blog.api.dataaccess.mapper;

import com.muhsener98.blog.api.dataaccess.entity.PostJpaEntity;
import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;



@Component
public class PostDataAccessMapper
{

    public PostJpaEntity toJpaEntity(Post post)
    {
        PostJpaEntity postJpaEntity = new PostJpaEntity();

        postJpaEntity.setId(post.getId().getValue());
        postJpaEntity.setTitle(post.getTitle().getValue());
        postJpaEntity.setContent(post.getContent().getContent());
        postJpaEntity.setAuthorId(post.getAuthorId().getValue());
        postJpaEntity.setCategory(post.getCategory());
        postJpaEntity.setTags(post.getTags().stream().map(PostTag::getVal).collect(Collectors.toList()));
        return postJpaEntity;
    }



    public Post toDomainEntity(PostJpaEntity postJpaEntity)
    {
        return Post.PostBuilder.builder()
                .id(new PostId(postJpaEntity.getId()))
                .title(new Title(postJpaEntity.getTitle()))
                .content(new PostContent(postJpaEntity.getContent()))
                .authorId(new AuthorId(postJpaEntity.getAuthorId()))
                .category(postJpaEntity.getCategory())
                .tags(postJpaEntity.getTags().stream().map(PostTag::of).collect(Collectors.toList()))
                .createdAt(CreatedAt.of(postJpaEntity.getCreatedAt()))
                .updatedAt(UpdatedAt.of(postJpaEntity.getUpdatedAt()))
                .build();
    }
}
