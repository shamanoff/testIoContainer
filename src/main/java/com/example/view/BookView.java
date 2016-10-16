package com.example.view;


public class BookView {


    private String title;
    private int id;
    private String Author;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return Author;
    }

    public BookView(int id, String title, String author) {
        this.title = title;
        this.id = id;
        Author = author;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", Author='" + Author + '\'' +
                '}';
    }
}
