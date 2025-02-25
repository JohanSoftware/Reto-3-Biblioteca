package com.gestion.biblioteca.service;
import static org.junit.jupiter.api.Assertions.*;

import com.gestion.biblioteca.exceptions.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gestion.biblioteca.model.Book;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void testAddBook() {
        // GIVEN
        bookService.addBook("1", "Habitos Atomicos", "James Clear");

        // WHEN - THEN
        assertEquals(1, bookService.getAllBooks().size());
        assertEquals("Habitos Atomicos", bookService.getAllBooks().get(0).getTitle());
    }

    @Test
    void testGetBookById() throws NoSuchElementException {
         // GIVEN
        bookService.addBook("1", "Habitos Atomicos", "James Clear");

        // WHEN
        Book book = bookService.getBookById("1");

        // THEN
        assertNotNull(book);
        assertEquals("Habitos Atomicos", book.getTitle());
    }

    @Test
    void testGetBookByIdNotFound() {
        // WHEN - THEN
        assertThrows(NoSuchElementException.class, () -> bookService.getBookById("2"));
    }
}
