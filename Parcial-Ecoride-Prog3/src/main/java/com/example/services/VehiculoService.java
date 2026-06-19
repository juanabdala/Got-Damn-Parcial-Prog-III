package com.example.services;

import org.springframework.stereotype.Service;

import com.example.dto.VehiculoDTO;
import com.example.models.Vehiculo;
import com.example.models.comparator.ComparadorTarifaDescendente;
import com.example.repository.EcoRideRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VehiculoService {

    private final EcoRideRepository repository;

    public VehiculoService(EcoRideRepository repository) {
        this.repository = repository;
    }

    public List<VehiculoDTO> ordenarPorPrioridadCarga() {
        List<Vehiculo> vehiculos = repository.getVehiculos();
        Collections.sort(vehiculos);
        return convertirADTO(vehiculos);
    }

    public List<VehiculoDTO> ordenarPorTarifaDescendente() {
        List<Vehiculo> vehiculos = repository.getVehiculos();
        Collections.sort(vehiculos, new ComparadorTarifaDescendente());
        return convertirADTO(vehiculos);
    }

    private List<VehiculoDTO> convertirADTO(List<Vehiculo> vehiculos) {
        List<VehiculoDTO> dtos = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            dtos.add(new VehiculoDTO(
                v.getPatente(),
                v.getPorcentajeBateria(),
                v.getTarifaBase(),
                v.getEstado().getNombre()
            ));
        }
        return dtos;
    }
}