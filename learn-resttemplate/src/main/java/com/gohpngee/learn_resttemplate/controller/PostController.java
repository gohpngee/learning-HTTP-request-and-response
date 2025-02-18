package com.gohpngee.learn_resttemplate.controller;

import com.gohpngee.learn_resttemplate.model.Post;
import com.gohpngee.learn_resttemplate.service.PostService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    //Constructs the service layer
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the Post API!";
    }

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        List<Post> posts = postService.fetchAllPosts();
        //System.out.println(posts.getFirst());
        return posts;
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getIdPost(@PathVariable int id) {
        JSONObject post = postService.fetchIdPost(id);

        if (post != null) {
            Map<String, Object> postMap = post.toMap();
            System.out.println("return type: " + postMap.getClass());
            System.out.println("post as map: " + postMap);
            return ResponseEntity.ok(post.toMap());
        }
        return ResponseEntity.notFound().build();
    }
}
