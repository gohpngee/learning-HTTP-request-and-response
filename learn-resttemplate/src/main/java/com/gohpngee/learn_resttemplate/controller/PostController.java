package com.gohpngee.learn_resttemplate.controller;

import com.gohpngee.learn_resttemplate.service.PostService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

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

    /*@GetMapping("/posts")
    //ResponseEntity returns data for successful requests, and a HTTP Status code for errors
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.fetchAllPosts();
        if (posts.isEmpty()) {
            //usage of .build() to set the response to 204 or 404
            //and avoid returning null value
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(posts); //returns a 200 OK with JSON arrayList of posts
    }*/

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getAllPosts() {
        return postService.fetchAllPosts();
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
