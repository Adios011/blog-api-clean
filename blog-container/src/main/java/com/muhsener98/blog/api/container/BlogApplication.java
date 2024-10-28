package com.muhsener98.blog.api.container;

import org.hibernate.boot.model.TypeDefinitionRegistryStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.sql.Driver;

@SpringBootApplication
@ComponentScan(basePackages = "com.muhsener98.blog.api")
@EnableWebSecurity(debug = true)
@EnableJpaRepositories(basePackages = "com.muhsener98.blog.api.dataaccess.repository")
@EntityScan(basePackages = "com.muhsener98.blog.api.dataaccess.entity")
@PropertySource("classpath:application.properties")
public class BlogApplication
{

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class , args);
    }
}
