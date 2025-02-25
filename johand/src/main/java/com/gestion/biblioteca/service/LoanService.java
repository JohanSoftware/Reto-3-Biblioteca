package com.gestion.biblioteca.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.gestion.biblioteca.exceptions.NoSuchElementException;

import com.gestion.biblioteca.model.Book;
import com.gestion.biblioteca.model.Loan;
import com.gestion.biblioteca.model.User;

public class LoanService {
    private List<Loan> loans;
    private BookService bookService;
    private UserServices userService;

    public LoanService(BookService bookService, UserServices userService) {
        this.loans = new ArrayList<>();
        this.bookService = bookService;
        this.userService = userService;
    }

    public void loanBook(String loanId, String idBook, String idUser, Date loanDate) throws NoSuchElementException {
        Book book = bookService.getBookById(idBook);
        User user = userService.getUserById(idUser);
        loans.add(new Loan(loanId, book, user, loanDate));
    }

    public List<Loan> getLoansByUserId(String userId) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUser().getIdUser().equals(userId)) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }

    public List<Loan> getAllLoans() {
        return loans;
    }
}
