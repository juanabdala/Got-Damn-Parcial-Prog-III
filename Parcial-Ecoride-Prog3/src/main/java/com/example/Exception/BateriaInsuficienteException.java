package com.example.Exception;

public class BateriaInsuficienteException extends RuntimeException {
    public BateriaInsuficienteException(int porcentaje) {
        super("Batería Insuficiente: El nivel de bateria es" + porcentaje + " %, minimo requerido es 15%");
    }
    
}
