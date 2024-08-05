package com.group.library_app.domain.book;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    protected Book() {

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Book(String name) {
       if(name == null || name.isEmpty()) {
           throw new IllegalArgumentException("비었음..");
       }

        this.name = name;
    }
}
