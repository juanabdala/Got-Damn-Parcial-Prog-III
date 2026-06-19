package com.example.models.comparator;

import java.util.Comparator;
import com.example.models.Vehiculo;

public class ComparadorTarifaDescendente implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo a, Vehiculo b) {
        return Double.compare(b.getTarifaBase(), a.getTarifaBase());
    }
}