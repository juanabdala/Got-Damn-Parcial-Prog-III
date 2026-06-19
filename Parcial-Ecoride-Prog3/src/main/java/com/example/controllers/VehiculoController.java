package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.VehiculoDTO;
import com.example.services.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/prioridad-carga")
    public ResponseEntity<List<VehiculoDTO>> prioridadCarga() {
        return ResponseEntity.ok(vehiculoService.ordenarPorPrioridadCarga());
    }

    @GetMapping("/tarifa-descendente")
    public ResponseEntity<List<VehiculoDTO>> tarifaDescendente() {
        return ResponseEntity.ok(vehiculoService.ordenarPorTarifaDescendente());
    }
}