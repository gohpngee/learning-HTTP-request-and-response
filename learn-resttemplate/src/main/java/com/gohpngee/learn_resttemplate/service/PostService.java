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

    public Post fetchIdPost(int targetId) {
        System.out.println("Fetching post: " + targetId);
        Post postObject = restTemplate.getForObject(baseUrl + "/" + targetId, Post.class);
        System.out.println("post object: " + postObject);
        return postObject;
    }

    public Post findLongestTitlePost() {
        List<Post> postArray = Arrays.asList(restTemplate.getForObject(baseUrl, Post[].class));

        if (postArray.isEmpty())
            return null;
        Post longestTitlePost = postArray.get(0);
        for (Post post : postArray) {
            if (post.getTitle().length() > longestTitlePost.getTitle().length()){
                longestTitlePost = post;
            }
        }
        return longestTitlePost;
    }

    public Post findShortestTitlePost() {
        List<Post> postArray = Arrays.asList(restTemplate.getForObject(baseUrl, Post[].class));

        if (postArray.isEmpty())
            return null;
        Post shortestTitlePost = postArray.get(0);
        for (Post post : postArray) {
            if (post.getTitle().length() < shortestTitlePost.getTitle().length())
                shortestTitlePost = post;
        }
        return shortestTitlePost;
    }

    public int findTitleLength(int targetId) {
        System.out.println("Finding length of title for post #" + targetId);
        Post postObject = restTemplate.getForObject(baseUrl + "/" + targetId, Post.class);
        return postObject.getTitleLength();
    }
}
