package com.muhsener98.blog.api.application.adapter;

import com.muhsener98.blog.api.domain.dto.PostDto;
import com.muhsener98.blog.api.domain.exception.InvalidDomainException;
import com.muhsener98.blog.api.domain.port.presenter.PostCrudPresenterOutputPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PostCrudPresenter implements PostCrudPresenterOutputPort {

    @Override
    public void presentInvalidInputsError(InvalidDomainException invalidDomainException) {

    }

    @Override
    public void presentPostCreatedResponse(PostDto postDetails) {

    }

    @Override
    public void presentPostNotFoundError(String searchKey, Object value) {

    }

    @Override
    public void presentPostUpdatedResponse(PostDto dto) {

    }

    @Override
    public void presentPostDeletedResponse(UUID id) {

    }

    @Override
    public void presentPostResponse(PostDto dto) {

    }

    @Override
    public void presentError(Exception e) {

    }
}
