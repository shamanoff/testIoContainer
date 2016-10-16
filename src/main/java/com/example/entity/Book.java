package com.example.entity;

import com.example.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Book implements Entity {

    private int id;
    private String title;


    public String getTitle() {
        return title;
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public int getId() {
        return id;
    }
}
