package com.example.a360chatapp.db.models;

public class Usuario {
    private String nombre;
    private String email;
    private String password;
    public Usuario() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

}
