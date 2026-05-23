package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Exception.BateriaInsuficienteException;
import com.example.Exception.VehiculoNoEncontradoException;
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
    public ResponseEntity<Map<String, String>> desbloquear(@RequestBody Map<String, Object> body) {
        try {
            int idUsuario = (int) body.get("idUsuario");
            String patente = (String) body.get("patente");
            String metodoPago = (String) body.get("metodoPago");
            String mensaje = alquilerService.desbloquear(idUsuario, patente, metodoPago);
            return ResponseEntity.ok(Map.of("resultado", mensaje));
        } catch (VehiculoNoEncontradoException | BateriaInsuficienteException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}