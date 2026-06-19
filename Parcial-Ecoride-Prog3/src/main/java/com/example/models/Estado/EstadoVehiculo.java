package com.example.models.Estado;

import com.example.models.Vehiculo;

public interface EstadoVehiculo {

    void iniciarViaje(Vehiculo vehiculo);
    void finalizarViaje(Vehiculo vehiculo);
    void enviarAReparacion(Vehiculo vehiculo);
    void finalizarReparacion(Vehiculo vehiculo);

    String getNombre();
}