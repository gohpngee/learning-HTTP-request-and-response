package com.gohpngee.learn_resttemplate.service;

import com.gohpngee.learn_resttemplate.model.Post;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> fetchAllPosts() {
        System.out.println("Fetching all posts");
        //uses the RestTemplate GET method to get the HTTP response and map it into an array of Post objects.
        Post[] posts = restTemplate.getForObject(baseUrl, Post[].class);
        return Arrays.asList(posts);
    }

    public Post fetchIdPost(int id) {
        System.out.println("Fetching post by id: " + id);
        String postUrl = baseUrl + "/" + id; //adding a slash at the back so i can include id

        ResponseEntity<String> response = restTemplate.exchange(postUrl, HttpMethod.GET, null, String.class);
        System.out.println("Response body: " + response.getBody());

        return restTemplate.getForObject(postUrl, Post.class);
    }
}
