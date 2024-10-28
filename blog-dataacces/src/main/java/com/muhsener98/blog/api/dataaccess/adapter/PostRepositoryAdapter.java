package com.muhsener98.blog.api.dataaccess.adapter;

import com.muhsener98.blog.api.dataaccess.entity.PostJpaEntity;
import com.muhsener98.blog.api.dataaccess.mapper.PostDataAccessMapper;
import com.muhsener98.blog.api.dataaccess.repository.PostJpaRepository;
import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.port.dataaccess.PersistenceException;
import com.muhsener98.blog.api.domain.port.dataaccess.PostRepository;
import com.muhsener98.blog.api.domain.valueobject.PostId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Slf4j
@Repository("postRepository")
public class PostRepositoryAdapter implements PostRepository {

    private final PostJpaRepository jpaRepository;
    private final PostDataAccessMapper dbMapper;

    public PostRepositoryAdapter(PostJpaRepository jpaRepository, PostDataAccessMapper dbMapper) {
        this.jpaRepository = jpaRepository;
        this.dbMapper = dbMapper;
    }

    @Override
    public Post save(Post postToBeSaved) throws PersistenceException {
        try {
            if (jpaRepository.existsById(postToBeSaved.getId().getValue()))
                throw new PersistenceException("Post already exists with provided id: " + postToBeSaved.getId().getValue());

            PostJpaEntity jpa = dbMapper.toJpaEntity(postToBeSaved);
            PostJpaEntity saved = jpaRepository.save(jpa);

            return dbMapper.toDomainEntity(saved);
        } catch (Exception e) {
            log.error("Error while saving post", e);
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Optional<Post> findById(PostId postId) {
        try {
            Optional<PostJpaEntity> optional = jpaRepository.findById(postId.getValue());
            return optional.map(dbMapper::toDomainEntity);
        } catch (Exception e) {
            log.error("Error while finding post", e);
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Post update(Post post) throws PersistenceException {
        try {
            if (post.getId() == null) {
                throw new PersistenceException("null ID to update ");
            }
            if (!jpaRepository.existsById(post.getId().getValue())) {
                throw new PersistenceException("No such post to update with provided id: " + post.getId().getValue());
            }


            PostJpaEntity jpaToBeUpdated = dbMapper.toJpaEntity(post);
            PostJpaEntity jpaUpdated = jpaRepository.save(jpaToBeUpdated);

            return dbMapper.toDomainEntity(jpaUpdated);


        } catch (Exception exception) {
            log.error("Error while updating post", exception);
            throw new PersistenceException("Error while updating post", exception);
        }

    }

    @Override
    public boolean deleteById(PostId postId) throws PersistenceException {
        try {
            if (jpaRepository.existsById(postId.getValue()))
                return false;

            jpaRepository.deleteById(postId.getValue());
            return true;
        } catch (Exception e) {
            log.error("Error while deleting post", e);
            throw new PersistenceException("Error while deleting post", e);
        }
    }
}
