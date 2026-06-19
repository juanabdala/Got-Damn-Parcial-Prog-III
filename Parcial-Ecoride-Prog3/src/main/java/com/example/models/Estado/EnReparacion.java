package com.example.models.Estado;

import com.example.Exception.EstadoInvalidoException;
import com.example.models.Vehiculo;

public class EnReparacion implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo está en reparación, no puede iniciar viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo no está en viaje.");
    }

    @Override
    public void enviarAReparacion(Vehiculo vehiculo) {
        throw new EstadoInvalidoException("El vehículo ya está en reparación.");
    }

    @Override
    public void finalizarReparacion(Vehiculo vehiculo) {
        vehiculo.setEstado(new EnEspera());
    }

    @Override
    public String getNombre() {
        return "En Reparación";
    }
}