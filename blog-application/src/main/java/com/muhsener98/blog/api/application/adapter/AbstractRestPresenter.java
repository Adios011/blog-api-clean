package com.muhsener98.blog.api.application.adapter;

import com.muhsener98.blog.api.domain.port.presenter.ErrorHandlingPresenterOutputPort;

public class AbstractRestPresenter extends AbstractErrorHandler implements ErrorHandlingPresenterOutputPort {

    @Override
    public void presentError(Exception e) {

    }
}
