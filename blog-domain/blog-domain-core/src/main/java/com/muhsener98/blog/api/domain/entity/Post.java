package com.muhsener98.blog.api.domain.entity;

import com.muhsener98.blog.api.domain.exception.InvalidDomainException;
import com.muhsener98.blog.api.domain.exception.PostDomainException;
import com.muhsener98.blog.api.domain.exception.ValidationError;
import com.muhsener98.blog.api.domain.valueobject.*;

import java.util.*;

public class Post extends BaseEntity<PostId> {

    private final Title title;
    private final PostContent content;
    private final PostCategory category;
    private final List<PostTag> tags;
    private final AuthorId authorId;

    private final CreatedAt createdAt;
    private UpdatedAt updatedAt;


    private Post(PostBuilder builder) {
        setId(builder.id);
        this.title = builder.title;
        this.content = builder.postContent;
        this.category = builder.category;
        this.tags = builder.postTags;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.authorId = builder.authorId;


    }

    /**
     * It validates the post and sets it's ID
     * @throws InvalidDomainException if validation fails
     */
    public void init() throws InvalidDomainException{
        validate();
        setId(new PostId(UUID.randomUUID()));
    }

    /**
     * It validates the post and controls if it has ID
     * @throws PostDomainException If It does not have ID
     * @throws InvalidDomainException if validation fails
     */
    public void update() throws PostDomainException , InvalidDomainException {
        validate();
        if(getId() == null )
            throw new PostDomainException("Post does not have ID, so it cannot be updated");


    }

    private void validate() {
        List<ValidationError> validationErrors = new ArrayList<>();
        if(title == null || !title.isValid())
            validationErrors.add(new ValidationError("title" , "title which contains at least 5 characters is required." ));

        if(content == null || !content.isValid())
            validationErrors.add(new ValidationError("content" , "post content is required"));

        if(tags.isEmpty())
            validationErrors.add(new ValidationError("tags" , "post must contains at least one tag"));

        for(PostTag tag : tags)
            if(tag == null || !tag.isValid())
                validationErrors.add(new ValidationError("tag" , "tag must contains at least 3 characters"));

        if(authorId == null  )
            validationErrors.add(new ValidationError("authorId" , "each post has to have an author"));



        if(!validationErrors.isEmpty()){
            throw new InvalidDomainException("Post" , validationErrors);
        }


    }


    public Title getTitle() {
        return title;
    }

    public PostContent getContent() {
        return content;
    }

    public PostCategory getCategory() {
        return category;
    }

    public List<PostTag> getTags() {
        return new ArrayList<>(this.tags);
    }

    public AuthorId getAuthorId() {
        return authorId;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public UpdatedAt getUpdatedAt() {
        return updatedAt;
    }




    public static final class PostBuilder {
        private Title title;
        private PostContent postContent;
        private PostCategory category;
        private List<PostTag> postTags;
        private PostId id;
        private AuthorId authorId;
        private CreatedAt createdAt;
        private UpdatedAt updatedAt;


        public static PostBuilder builder() {
            return new PostBuilder();
        }

        public PostBuilder id(PostId id) {
            this.id = id;
            return this;
        }

        public PostBuilder title(Title title) {
            this.title = title;
            return this;
        }

        public PostBuilder content(PostContent postContent) {
            this.postContent = postContent;
            return this;
        }

        public PostBuilder category(PostCategory category) {
            this.category = category;
            return this;
        }


        public PostBuilder tags(List<PostTag> postTags) {
            this.postTags = postTags;
            return this;
        }



        public PostBuilder createdAt(CreatedAt createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public PostBuilder updatedAt(UpdatedAt updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public PostBuilder authorId(AuthorId authorId){
            this.authorId = authorId;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}
