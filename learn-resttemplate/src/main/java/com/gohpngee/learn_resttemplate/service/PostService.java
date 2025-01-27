package com.gohpngee.learn_resttemplate.service;

import com.gohpngee.learn_resttemplate.model.Post;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    public ResponseEntity<String> fetchAllPosts() {
        System.out.println("Fetching all posts");
        return restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
    }

    public ResponseEntity<String> fetchIdPost(int id) {
        System.out.println("Fetching post by id: " + id);
        String postUrl = baseUrl + "/" + id; //adding a slash at the back so i can include id

        ResponseEntity<String> response = restTemplate.exchange(postUrl, HttpMethod.GET, null, String.class);
        System.out.println("Response body: " + response.getBody());

        return response;
    }

    /*public Post fetchLongestTitlePost() {
        //Fetch all posts first
        System.out.println("Fetching all posts.");

        ResponseEntity<List<Post>> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, )
    }*/
}
