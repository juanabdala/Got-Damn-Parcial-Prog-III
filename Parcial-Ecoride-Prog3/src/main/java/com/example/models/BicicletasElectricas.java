package com.example.models;

public class BicicletasElectricas extends Vehiculo {

    private int capacidadCanasto;

    public BicicletasElectricas(String patente, int porcentajeBateria, double tarifaBase, int capacidadCanasto) {
        super(patente, porcentajeBateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;

    }

    public int getcapacidadCanasto() {
        return capacidadCanasto;
    }

}
