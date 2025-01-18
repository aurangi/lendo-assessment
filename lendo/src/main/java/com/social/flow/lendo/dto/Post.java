package com.social.flow.lendo.dto;

import lombok.Data;

@Data
public class Post {
    private long id;
    private String userId;
    private String title;
    private String body;
}
