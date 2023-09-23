package com.jobin.jobin.post;



import com.jobin.jobin.post.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    PostService postService ;

    @GetMapping("/")
    public List<Post> findAllPost(){
        return  postService.findAllPosts();
    }
    @GetMapping("/{id}")
    public List<Post> findPostsByUserId(@PathVariable int id){
        return  postService.findPostsByUserId(id) ;
    }

    @PostMapping("/save-post")
    public Map<String , Object> createPost(@RequestBody Post post){
        return  postService.createPost(post);
    }
}
