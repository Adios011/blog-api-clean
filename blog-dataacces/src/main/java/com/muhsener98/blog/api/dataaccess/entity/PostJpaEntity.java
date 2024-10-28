package com.muhsener98.blog.api.dataaccess.entity;

import com.muhsener98.blog.api.dataaccess.converter.StringListConverter;
import com.muhsener98.blog.api.domain.valueobject.PostCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

    @Entity
    @Table(name = "posts")
    @NoArgsConstructor
    @AllArgsConstructor()
    @Getter
    @Setter
    public class PostJpaEntity {
        @Id
        private UUID id;

        @Column(name = "title")
        private String title;

        @Column(name = "content", length = 1500)
        private String content;

        @Enumerated(value = EnumType.STRING)
        private PostCategory category;

        @Convert(converter = StringListConverter.class)
        private List<String> tags;

        @Column(name = "author_id", length = 100, columnDefinition = "uuid")
        private UUID authorId;

        @Temporal(TemporalType.TIME)
        @Column(name = "created_at")
        private Date createdAt;

        @Temporal(TemporalType.TIME)
        @Column(name = "updated_at")
        private Date updatedAt;




}
