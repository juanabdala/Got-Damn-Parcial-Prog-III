package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class EstacionAnclaje {

    private String nombre;
    private List <Vehiculo> vehiculos;

    public EstacionAnclaje(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarVehiculoPatente(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                return vehiculo;
            }
        }
        return null;
    }
}
