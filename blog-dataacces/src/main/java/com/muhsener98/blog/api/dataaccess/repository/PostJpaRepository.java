package com.muhsener98.blog.api.dataaccess.repository;

import com.muhsener98.blog.api.dataaccess.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostJpaRepository extends JpaRepository<PostJpaEntity, UUID> {
}
