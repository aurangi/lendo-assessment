package com.social.flow.lendo.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
