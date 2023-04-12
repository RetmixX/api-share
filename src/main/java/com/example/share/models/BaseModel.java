package com.example.share.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public BaseModel() {
    }

    public int getId() {
        return id;
    }
}
