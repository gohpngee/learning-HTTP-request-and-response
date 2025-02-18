package com.gohpngee.learn_resttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("idd")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
}