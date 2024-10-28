package com.muhsener98.blog.api.domain.usecase;

import com.muhsener98.blog.api.domain.dto.CreatePostCommand;
import com.muhsener98.blog.api.domain.dto.PostDto;
import com.muhsener98.blog.api.domain.dto.UpdatePostCommand;
import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.exception.InvalidDomainException;
import com.muhsener98.blog.api.domain.mapper.PostDataMapper;
import com.muhsener98.blog.api.domain.port.dataaccess.PostRepository;
import com.muhsener98.blog.api.domain.port.presenter.PostCrudPresenterOutputPort;
import com.muhsener98.blog.api.domain.port.security.SecurityOutputPort;
import com.muhsener98.blog.api.domain.valueobject.PostId;

import java.util.Optional;
import java.util.UUID;

public class PostCrudUseCase implements PostCrudInputPort {

    private final PostRepository repository;
    private final PostCrudPresenterOutputPort presenter;
    private final SecurityOutputPort securityOutputPort;
    private final PostDataMapper dataMapper;

    public PostCrudUseCase(PostRepository repository, PostCrudPresenterOutputPort presenter,
                           SecurityOutputPort securityOutputPort, PostDataMapper postDataMapper) {
        this.repository = repository;
        this.presenter = presenter;
        this.securityOutputPort = securityOutputPort;
        this.dataMapper = postDataMapper;
    }

    @Override
    public void createPost(CreatePostCommand command) {

        try {
            securityOutputPort.assertThatUserHasRole("USER");

            Post postToBeSaved = null;
            try {
                postToBeSaved = dataMapper.toDomainEntity(command);
            } catch (InvalidDomainException invalidDomainException) {
                presenter.presentInvalidInputsError(invalidDomainException);
                return;
            }

            postToBeSaved.init();

            Post postSaved = repository.save(postToBeSaved);
            PostDto postDetails = dataMapper.toDto(postSaved);

            presenter.presentPostCreatedResponse(postDetails);


        } catch (Exception exception) {
            presenter.presentError(exception);
        }
    }

    @Override
    public void updatePost(UpdatePostCommand command) {

        try {

            Optional<Post> optionalPost = repository.findById(new PostId(command.getId()));
            if (optionalPost.isEmpty()) {
                presenter.presentPostNotFoundError("id", command.getId());
                return;
            }
            Post postToBeUpdated = optionalPost.get();

            securityOutputPort.assertThatUserHasPermissionToUpdate(postToBeUpdated);

            Post mergedPostWithNewValues = dataMapper.merge(postToBeUpdated, command);
            mergedPostWithNewValues.update();

            Post updatedPost = repository.update(mergedPostWithNewValues);


            presenter.presentPostUpdatedResponse(dataMapper.toDto(updatedPost));


        } catch (Exception exception) {
            presenter.presentError(exception);
        }

    }

    @Override
    public void deletePost(UUID id) {

        try {

            boolean isDeleted = repository.deleteById(new PostId(id));
            if (!isDeleted) {
                presenter.presentPostNotFoundError("id", id);
            } else {
                presenter.presentPostDeletedResponse(id);
            }


        } catch (Exception exception) {
            presenter.presentError(exception);
        }
    }

    @Override
    public void getPostById(UUID id) {
        try {

            Optional<Post> optionalPost = repository.findById(new PostId(id));
            if (optionalPost.isEmpty()) {
                presenter.presentPostNotFoundError("id", id);
                return;
            }
            Post post = optionalPost.get();
            presenter.presentPostResponse(dataMapper.toDto(post));
        } catch (Exception exception) {
            presenter.presentError(exception);

        }

    }
}
