package com.example.models.Tarifa;

public class TarifaHoraPico implements EstrategiaTarifa {

    private static final double RECARGO = 1.40;

    @Override
    public double calcular(int minutos, double tarifaBase) {
        double costoBase = minutos * tarifaBase;
        return costoBase * RECARGO;
    }
}