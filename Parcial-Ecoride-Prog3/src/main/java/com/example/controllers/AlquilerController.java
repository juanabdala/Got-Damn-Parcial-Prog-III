package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Exception.BateriaInsuficienteException;
import com.example.Exception.EstadoInvalidoException;
import com.example.Exception.VehiculoNoEncontradoException;
import com.example.dto.RespuestaAlquilerDTO;
import com.example.services.AlquilerService;

import java.util.Map;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping("/desbloquear")
    public ResponseEntity<?> desbloquear(@RequestBody Map<String, Object> body) {
        try {
            int idUsuario = (int) body.get("idUsuario");
            String patente = (String) body.get("patente");
            RespuestaAlquilerDTO respuesta = alquilerService.desbloquear(idUsuario, patente);
            return ResponseEntity.ok(respuesta);
        } catch (VehiculoNoEncontradoException | BateriaInsuficienteException | EstadoInvalidoException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/finalizar")
    public ResponseEntity<?> finalizar(@RequestBody Map<String, Object> body) {
        try {
            int idUsuario = (int) body.get("idUsuario");
            String patente = (String) body.get("patente");
            int minutos = (int) body.get("minutos");
            String metodoPago = (String) body.get("metodoPago");
            RespuestaAlquilerDTO respuesta = alquilerService.finalizar(idUsuario, patente, minutos, metodoPago);
            return ResponseEntity.ok(respuesta);
        } catch (VehiculoNoEncontradoException | EstadoInvalidoException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}