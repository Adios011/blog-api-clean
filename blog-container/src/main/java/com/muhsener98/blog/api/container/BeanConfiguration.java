package com.muhsener98.blog.api.container;

import com.muhsener98.blog.api.domain.mapper.PostDataMapper;
import com.muhsener98.blog.api.domain.port.dataaccess.PostRepository;
import com.muhsener98.blog.api.domain.port.presenter.PostCrudPresenterOutputPort;
import com.muhsener98.blog.api.domain.port.security.SecurityOutputPort;
import com.muhsener98.blog.api.domain.usecase.PostCrudInputPort;
import com.muhsener98.blog.api.domain.usecase.PostCrudUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public PostCrudInputPort postCrudInputPort(PostRepository postRepository, PostCrudPresenterOutputPort postCrudPresenterOutputPort,
                                               SecurityOutputPort securityOutputPort, PostDataMapper postDataMapper) {
        return new PostCrudUseCase(postRepository, postCrudPresenterOutputPort, securityOutputPort, postDataMapper);
    }

    @Bean
    public PostDataMapper postDataMapper(){
        return new PostDataMapper();
    }
}
