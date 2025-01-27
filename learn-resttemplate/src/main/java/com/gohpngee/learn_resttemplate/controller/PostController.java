package com.gohpngee.learn_resttemplate.controller;

import com.gohpngee.learn_resttemplate.model.Post;
import com.gohpngee.learn_resttemplate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/posts/{id}", produces = "application/json")
    public ResponseEntity<String> getIdPost(@PathVariable int id) {
        ResponseEntity<String> post = postService.fetchIdPost(id);
        if (post == null) {
            return ResponseEntity.noContent().build();
        }
        return post;
        //return ResponseEntity<Post>(post, HttpStatus.CREATED); // HTTP response 200, OK
    }
}
