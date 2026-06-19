package com.example.models;

public class UsuarioRegular extends Usuario {

    public UsuarioRegular(int id, String nombreCompleto) {
        super(id, nombreCompleto);
    }

    @Override
    public double aplicarDescuento(double monto) {
        // No aplica descuento para usuarios regulares
        return monto;
    }



    
}
