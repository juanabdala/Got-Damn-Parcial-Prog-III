package com.example.dto;

public class RespuestaAlquilerDTO {

    private String patente;
    private double costoFinal;
    private long minutosTranscurridos;
    private String faseActual;

    public RespuestaAlquilerDTO(String patente, double costoFinal, long minutosTranscurridos, String faseActual) {
        this.patente = patente;
        this.costoFinal = costoFinal;
        this.minutosTranscurridos = minutosTranscurridos;
        this.faseActual = faseActual;
    }

    public String getPatente() { return patente; }
    public double getCostoFinal() { return costoFinal; }
    public long getMinutosTranscurridos() { return minutosTranscurridos; }
    public String getFaseActual() { return faseActual; }
}