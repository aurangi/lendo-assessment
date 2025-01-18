package com.social.flow.lendo.dto;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
