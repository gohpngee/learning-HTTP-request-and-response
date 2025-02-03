package com.gohpngee.learn_resttemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Post{" +
                "userId = " + userId +
                "id = " + id +
                "title = " + title +
                "body = " + body + "}";
    }
}