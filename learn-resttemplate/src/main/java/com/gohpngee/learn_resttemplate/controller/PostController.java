package com.gohpngee.learn_resttemplate.controller;

import com.gohpngee.learn_resttemplate.model.Post;
import com.gohpngee.learn_resttemplate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        Post[] posts =
    }
}
