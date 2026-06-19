package com.example.models.Estado;

import com.example.Exception.EstadoInvalidoException;
import com.example.models.Vehiculo;

public class EnEspera implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnViaje());
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo no está en viaje.");
    }

    @Override
    public void enviarAReparacion(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnReparacion());
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo no está en reparación.");
    }

    @Override
    public String getNombre() {
        return "En Espera";
    }
}