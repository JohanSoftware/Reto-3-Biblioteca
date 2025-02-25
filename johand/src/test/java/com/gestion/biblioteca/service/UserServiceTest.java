package com.gestion.biblioteca.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserServices userService;

    @BeforeEach
    void setUp() {
        userService = new UserServices();
    }

    @Test
    void testAddUser() {
        // GIVEN
        userService.addUser("1", "Johan David");

        // WHEN - THEN
        assertEquals(1, userService.getAllUsers().size());
        assertEquals("Johan David", userService.getAllUsers().get(0).getName());
    }
}
