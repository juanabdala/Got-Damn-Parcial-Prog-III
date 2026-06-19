package com.example.models.Tarifa;

public class TarifaEstandar implements EstrategiaTarifa {

    @Override
    public double calcular(int minutos, double tarifaBase) {
        return minutos * tarifaBase;
    }
}