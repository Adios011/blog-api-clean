package com.muhsener98.blog.api.domain.port.dataaccess;

import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.valueobject.PostId;

import java.util.Optional;

public interface PostRepository {

    /**
     * Saves post in database.
     *
     * @param postToBeSaved - Post to be saved
     * @return saved Post
     * @throws PersistenceException if there is an error in the database
     */
    Post save(Post postToBeSaved) throws PersistenceException;

    /**
     * Find Post by id.
     * @param postId identifier of the Post
     * @return optional of Post. If post does not exist, it returns empty.
     */
    Optional<Post> findById(PostId postId);

    /**
     * @param post - Post to be updated
     * @return updated Post
     * @throws PersistenceException This method will throw PersistenceException if there is an error in the database
     */
    Post update(Post post) throws PersistenceException;


    /**
     * Deletes Post from database.
     *
     * @param postId identifier of the Post to be deleted
     * @return If post exists and deleted successfully, it returns true.
     * If post does not exist, it returns false.
     * @throws PersistenceException if there is an error in the database
     */
    boolean deleteById(PostId postId) throws PersistenceException;
}
