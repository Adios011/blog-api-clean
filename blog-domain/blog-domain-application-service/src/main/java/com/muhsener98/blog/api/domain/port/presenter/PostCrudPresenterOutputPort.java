package com.muhsener98.blog.api.domain.port.presenter;

import com.muhsener98.blog.api.domain.dto.PostDto;
import com.muhsener98.blog.api.domain.exception.InvalidDomainException;

import java.util.UUID;

public interface PostCrudPresenterOutputPort extends ErrorHandlingPresenterOutputPort {

    void presentInvalidInputsError(InvalidDomainException invalidDomainException);

    void presentPostCreatedResponse(PostDto postDetails);

    void presentPostNotFoundError(String searchKey, Object value);

    void presentPostUpdatedResponse(PostDto dto);

    void presentPostDeletedResponse(UUID id);

    void presentPostResponse(PostDto dto);
}
