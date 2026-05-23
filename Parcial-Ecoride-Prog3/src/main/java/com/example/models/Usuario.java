package com.example.models;

public abstract class Usuario {

    private int id;
    private String nombreCompleto;

    public Usuario(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public abstract double aplicarDescuento(double monto);
    
    
}
