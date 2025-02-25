package com.gestion.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import com.gestion.biblioteca.exceptions.NoSuchElementException;

import com.gestion.biblioteca.model.Book;

public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    public void addBook(String idBook, String title, String author){
        books.add(new Book(idBook, title, author));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(String idBook) throws NoSuchElementException{
        for (var book : books) {
            if (book.getIdBook().equals(idBook)) {
                return book;
            }
        }
        throw new NoSuchElementException("No fue encontrado el libro con el id: "+ idBook);
    }


}
