package com.gestion.biblioteca;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.gestion.biblioteca.exceptions.NoSuchElementException;
import com.gestion.biblioteca.model.Book;
import com.gestion.biblioteca.model.Loan;
import com.gestion.biblioteca.service.BookService;
import com.gestion.biblioteca.service.LoanService;
import com.gestion.biblioteca.service.UserServices;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        UserServices userService = new UserServices();
        LoanService loanService = new LoanService(bookService, userService);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Consultar un libro por ID");
            System.out.println("3. Registrar un usuario");
            System.out.println("4. Realizar un préstamo");
            System.out.println("5. Consultar préstamos por usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Agregar un libro
                    System.out.print("Ingrese el ID del libro: ");
                    String idBook = scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String author = scanner.nextLine();
                    bookService.addBook(idBook, title, author);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    // Consultar un libro por ID
                    System.out.print("Ingrese el ID del libro a consultar: ");
                    String idBookConsulta = scanner.nextLine();
                    try {
                        Book libro = bookService.getBookById(idBookConsulta);
                        System.out.println("Libro encontrado: " + libro.getTitle() + " por " + libro.getAuthor());
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Registrar un usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUser = scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String name = scanner.nextLine();
                    userService.addUser(idUser, name);
                    System.out.println("Usuario registrado correctamente.");
                    break;

                case 4:
                    // Realizar un préstamo
                    System.out.print("Ingrese el ID del préstamo: ");
                    String idLoan = scanner.nextLine();
                    System.out.print("Ingrese el ID del libro: ");
                    String idBookPrestamo = scanner.nextLine();
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUserPrestamo = scanner.nextLine();
                    try {
                        loanService.loanBook(idLoan, idBookPrestamo, idUserPrestamo, new Date());
                        System.out.println("Préstamo registrado correctamente.");
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Consultar préstamos por usuario
                    System.out.print("Ingrese el ID del usuario: ");
                    String idUserConsulta = scanner.nextLine();
                    List<Loan> prestamos = loanService.getLoansByUserId(idUserConsulta);
                    if (prestamos.isEmpty()) {
                        System.out.println("No se encontraron préstamos para este usuario.");
                    } else {
                        System.out.println("Préstamos del usuario:");
                        for (Loan prestamo : prestamos) {
                            System.out.println("Libro: " + prestamo.getBook().getTitle() + 
                                             ", Fecha: " + prestamo.getLoanDate());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}