package com.example.dto;

public class VehiculoDTO {

    private String patente;
    private int porcentajeBateria;
    private double tarifaBase;
    private String faseActual;

    public VehiculoDTO(String patente, int porcentajeBateria, double tarifaBase, String faseActual) {
        this.patente = patente;
        this.porcentajeBateria = porcentajeBateria;
        this.tarifaBase = tarifaBase;
        this.faseActual = faseActual;
    }

    public String getPatente() { return patente; }
    public int getPorcentajeBateria() { return porcentajeBateria; }
    public double getTarifaBase() { return tarifaBase; }
    public String getFaseActual() { return faseActual; }
}