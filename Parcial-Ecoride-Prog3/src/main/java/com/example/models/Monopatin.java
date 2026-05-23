package com.example.models;

public class Monopatin extends Vehiculo {

    private boolean tieneAmortiguacion;

    public Monopatin(String patente, int porcentajeBateria, double tarifaBase, boolean tieneAmortiguacion) {
        super(patente, porcentajeBateria, tarifaBase);
        this.tieneAmortiguacion = tieneAmortiguacion;
    }

    public boolean isTieneAmortiguacion() {
        return tieneAmortiguacion;
    }

    public void setTieneAmortiguacion(boolean tieneAmortiguacion) {
        this.tieneAmortiguacion = tieneAmortiguacion;
    }

}
