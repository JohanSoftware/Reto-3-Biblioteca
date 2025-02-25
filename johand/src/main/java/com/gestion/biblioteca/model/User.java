package com.gestion.biblioteca.model;

public class User {

    private String idUser;
    private String name;
    
    public User(String idUser, String name) {
        this.idUser = idUser;
        this.name = name;
    }

    public String getIdUser() {
        return idUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
}
