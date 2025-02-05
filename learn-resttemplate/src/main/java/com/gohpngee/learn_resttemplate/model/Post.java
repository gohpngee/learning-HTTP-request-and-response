package com.gohpngee.learn_resttemplate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

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