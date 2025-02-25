package com.gestion.biblioteca.model;

public class Book {

    private String idBook;
    private String title;
    private String author;

    public Book(String idBook, String title, String author) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
    }

    public String getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    


}
