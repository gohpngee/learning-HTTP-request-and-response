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
    public ResponseEntity<Post> getIdPost(@PathVariable int id) {
        Post post = postService.fetchIdPost(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/posts/shortest-title-post")
    public ResponseEntity<Post> getShortestTitlePost() {
        Post shortestTitlePost = postService.findShortestTitlePost();
        return ResponseEntity.ok(shortestTitlePost);
    }

    @GetMapping("/posts/longest-title-post")
    public ResponseEntity<Post> getLongestTitlePost() {
        Post longestTitlePost = postService.findLongestTitlePost();
        return ResponseEntity.ok(longestTitlePost);
    }

    @GetMapping(value = "/post/length-title/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getPostTitleLength(@PathVariable int id) {
        int titleLength = postService.findTitleLength(id);
        return ResponseEntity.ok(titleLength);
    }
}
