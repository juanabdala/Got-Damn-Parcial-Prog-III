package com.example.models;

public class UsuarioPremium extends Usuario{

    private double porcentajeDescuento;
    public UsuarioPremium(int id, String nombreCompleto, double porcentajeDescuento) {
        super(id, nombreCompleto);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * porcentajeDescuento / 100);
    }
    
}
