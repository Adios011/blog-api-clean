package com.muhsener98.blog.api.dataaccess;

import com.muhsener98.blog.api.dataaccess.mapper.PostDataAccessMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    @Order(1)
    public   PostDataAccessMapper postDataAccessMapper(){
        System.out.println("in postDataAccessMapper()");
        System.out.println(url);
        return new PostDataAccessMapper();
    }


}

