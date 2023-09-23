package com.jobin.jobin.post;



import com.jobin.jobin.post.models.Post;
import com.jobin.jobin.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository ;
    public List<Post> findPostsByUserId(int id) {
      return   postRepository.findByUserId(id) ;
    }

    public Map<String , Object> createPost(Post post) {
        Map<String , Object> result  = new HashMap<>();
        try{
            Post newPost = postRepository.save(post);
            result.put("resultCode", Constant.successResult);
            result.put("post" , newPost);
            return result;
        }catch (Exception e){
            result.put("resultCode" , Constant.internalServerError);
            result.put("resultMessage" , e.getMessage());
            return result;
        }

    }

    public List<Post> findAllPosts() {
        return (List<Post>) postRepository.findAll();
    }
}
