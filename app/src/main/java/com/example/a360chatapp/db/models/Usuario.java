package com.example.a360chatapp.db.models;

import com.google.firebase.Timestamp;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String nombreImagenPerfil;
    private Timestamp fechaCreacion;
    private Boolean estadoConexion;
    private List<String>amigosId;

    public Usuario() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Usuario(String id, String nombre , String email,Timestamp fechaCreacion ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.nombreImagenPerfil = "default.png";
        this.estadoConexion = false;
        this.fechaCreacion = fechaCreacion;
        this.amigosId = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreImagenPerfil() {
        return nombreImagenPerfil;
    }

    public void setNombreImagenPerfil(String nombreImagenPerfil) {
        this.nombreImagenPerfil = nombreImagenPerfil;
    }

    public Boolean getEstadoConexion() {
        return estadoConexion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstadoConexion(Boolean estadoConexion) {
        this.estadoConexion = estadoConexion;
    }
}
