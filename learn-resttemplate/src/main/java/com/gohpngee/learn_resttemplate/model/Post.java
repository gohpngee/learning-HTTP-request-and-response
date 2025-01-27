package com.gohpngee.learn_resttemplate.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
    //private int titleLength;

    /*public int getTitleLength() {
        return title.length();
    }*/
}