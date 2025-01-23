package com.gohpngee.learn_resttemplate.service;

import com.gohpngee.learn_resttemplate.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Post> fetchAllPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        //uses the RestTemplate GET method to get the HTTP response and map it into an array of Post objects.
        Post[] posts = restTemplate.getForObject(url, Post[].class);

    }
}
