package com.gestion.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import com.gestion.biblioteca.exceptions.NoSuchElementException;
import com.gestion.biblioteca.model.User;

public class UserServices {

    private List<User> users = new ArrayList<>();

    public void addUser( String idUser, String name) {
        users.add(new User(idUser, name));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(String idUser) throws NoSuchElementException {
        for (var user : users) {
            if (user.getIdUser().equals(idUser)) {
                return user;
            }

        }
        throw new NoSuchElementException("No existe un usaurio con el id: " + idUser );
    }

    

}
