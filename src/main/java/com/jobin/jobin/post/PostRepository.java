package com.jobin.jobin.post;

import com.jobin.jobin.post.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findByUserId(Integer userID);
}
