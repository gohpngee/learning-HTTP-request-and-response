package com.gohpngee.learn_resttemplate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gohpngee.learn_resttemplate.model.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    public PostService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<Post> fetchAllPosts() {
        System.out.println("Fetching all posts");
        Post[] postArray = restTemplate.getForObject(baseUrl, Post[].class);
        System.out.println("blabla: " + postArray.length);
        return Arrays.asList(postArray); //convert to a list because more dynamic
    }

    public JSONObject fetchIdPost(int targetId) {
        System.out.println("Fetching all posts");
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/" + targetId, HttpMethod.GET, null, String.class);
        JSONArray postArray = new JSONArray(response.getBody());

        for (int i = 0; i < postArray.length(); i++) {
            JSONObject post = postArray.getJSONObject(i);
            if (post.getInt("id") == targetId)
                return post;
        }
        return null;
    }

   /* public ResponseEntity<String> fetchIdPost(int id) {
        System.out.println("Fetching post by id: " + id);
        String postUrl = baseUrl + "/" + id; //adding a slash at the back so i can include id

        ResponseEntity<String> response = restTemplate.exchange(postUrl, HttpMethod.GET, null, String.class);


        System.out.println("Response body: " + response.getBody());

        return response;
    }*/

    /*public Post fetchLongestTitlePost() {
        //Fetch all posts first
        System.out.println("Fetching all posts.");

        ResponseEntity<List<Post>> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, )
    }*/
}
