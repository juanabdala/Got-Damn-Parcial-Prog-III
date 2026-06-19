package com.example.models;

import com.example.models.Estado.EnEspera;
import com.example.models.Estado.EstadoVehiculo;

public abstract class Vehiculo implements Comparable<Vehiculo> {

    private String patente;
    private int porcentajeBateria;
    private double tarifaBase;
    private EstadoVehiculo estado;

    public Vehiculo(String patente, int porcentajeBateria, double tarifaBase) {
        this.patente = patente;
        this.porcentajeBateria = porcentajeBateria;
        this.tarifaBase = tarifaBase;
        this.estado = new EnEspera();
    }

    public String getPatente() {
        return patente;
    }

    public int getPorcentajeBateria() {
        return porcentajeBateria;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public void iniciarViaje() {
        estado.iniciarViaje(this);
    }

    public void finalizarViaje() {
        estado.finalizarViaje(this);
    }

    public void enviarAReparacion() {
        estado.enviarAReparacion(this);
    }

    public void finalizarReparacion() {
        estado.finalizarReparacion(this);
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.porcentajeBateria, otro.porcentajeBateria);
    }
}