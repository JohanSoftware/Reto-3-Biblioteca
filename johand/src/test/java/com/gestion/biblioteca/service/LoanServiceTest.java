package com.gestion.biblioteca.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gestion.biblioteca.exceptions.NoSuchElementException;
import com.gestion.biblioteca.model.Book;
import com.gestion.biblioteca.model.Loan;
import com.gestion.biblioteca.model.User;

public class LoanServiceTest {

    @Mock
    private BookService bookService;

    @Mock
    private UserServices userService;

    @InjectMocks
    private LoanService loanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoanBook() throws NoSuchElementException {
        // GIVEN
        Book book = new Book("1", "Habitos Atomicos", "James Clear");
        User user = new User("1", "Johan David");

        when(bookService.getBookById("1")).thenReturn(book);
        when(userService.getUserById("1")).thenReturn(user);

        // WHEN 
        loanService.loanBook("1", "1", "1", new Date());

        // THEN
        List<Loan> loans = loanService.getAllLoans();
        assertEquals(1, loans.size());
        assertEquals("Habitos Atomicos", loans.get(0).getBook().getTitle());
        assertEquals("Johan David", loans.get(0).getUser().getName());
    }

    @Test
    void testGetLoansByUserId() throws NoSuchElementException {
        // GIVEN
        Book book = new Book("1", "Habitos Atomicos", "James Clear");
        User user = new User("1", "Johan David");

        // WHEN
        when(bookService.getBookById("1")).thenReturn(book);
        when(userService.getUserById("1")).thenReturn(user);

        loanService.loanBook("1", "1", "1", new Date());

        
        List<Loan> userLoans = loanService.getLoansByUserId("1");

        // THEN
        assertEquals(1, userLoans.size());
        assertEquals("Habitos Atomicos", userLoans.get(0).getBook().getTitle());
    }
}
