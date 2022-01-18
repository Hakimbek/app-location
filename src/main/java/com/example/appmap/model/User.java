package com.example.appmap.model;

import javax.persistence.*;

@Entity(name = "user_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String familyName;
}
