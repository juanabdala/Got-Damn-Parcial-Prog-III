package com.example.models.Estado;

import com.example.Exception.EstadoInvalidoException;
import com.example.models.Vehiculo;

public class EnViaje implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo ya está en viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnEspera());
    }

    @Override
    public void enviarAReparacion(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("No se puede enviar a reparación un vehículo en viaje.");
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo no está en reparación.");
    }

    @Override
    public String getNombre() {
        return "En Viaje";
    }
}