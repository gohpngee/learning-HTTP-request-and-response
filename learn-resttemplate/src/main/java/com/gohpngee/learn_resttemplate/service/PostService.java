package com.gohpngee.learn_resttemplate.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gohpngee.learn_resttemplate.model.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String baseUrl = "https://jsonplaceholder.typicode.com/posts";

    public ResponseEntity<String> fetchAllPosts() {
        System.out.println("Fetching all posts");
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        JSONArray jsonArray = new JSONArray(response.getBody());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("Post #" + (i + 1) + ": " + jsonObject);
        }
        return ResponseEntity.ok(jsonArray.toString());
    }

    public JSONObject fetchIdPost(int targetId) {
        System.out.println("Fetching all posts");
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        JSONArray postArray = new JSONArray(response.getBody());

        for (int i = 0; i < postArray.length(); i++) {
            JSONObject post = postArray.getJSONObject(i);
            if (post.getInt("id") == targetId)
                return post;
        }
        return null;
    }

    public ResponseEntity<String> afetchIdPost(int id) {
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
