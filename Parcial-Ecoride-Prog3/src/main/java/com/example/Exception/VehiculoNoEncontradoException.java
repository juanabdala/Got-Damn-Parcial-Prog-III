package com.example.Exception;

public class VehiculoNoEncontradoException extends RuntimeException{
    public VehiculoNoEncontradoException(String patente) {
        super("Vehiculo No Encontrado: no existe un vehiculo con patente" + patente + "en la estacion.");
    }
    
}
