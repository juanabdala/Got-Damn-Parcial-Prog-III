package com.example.models.Tarifa;

public class TarifaTemporalClimatico implements EstrategiaTarifa {

    private static final double RECARGO_FIJO = 150.0; 

    @Override
    public double calcular(int minutos, double tarifaBase) {
        double costoBase = minutos * tarifaBase;
        return costoBase + RECARGO_FIJO;
    }
}