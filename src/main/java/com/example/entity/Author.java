package com.example.entity;

import com.example.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Author implements Entity {

    private String name;
    private int id;
    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }


    public Author(String name, int id, int bookId) {
        this.name = name;
        this.id = id;
        this.bookId = bookId;
    }

    @Override
    public int getId() {
        return id;
    }
}
