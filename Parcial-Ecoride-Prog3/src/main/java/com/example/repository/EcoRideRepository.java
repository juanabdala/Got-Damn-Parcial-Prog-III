package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.models.BicicletasElectricas;
import com.example.models.EstacionAnclaje;
import com.example.models.Monopatin;
import com.example.models.Usuario;
import com.example.models.UsuarioPremium;
import com.example.models.UsuarioRegular;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EcoRideRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<EstacionAnclaje> estaciones = new ArrayList<>();

    public EcoRideRepository() {
        cargarDatos();
    }

    private void cargarDatos() {
        usuarios.add(new UsuarioRegular(1, "Juan Pérez"));
        usuarios.add(new UsuarioRegular(2, "María García"));
        usuarios.add(new UsuarioPremium(3, "Carlos López", 10.0));
        usuarios.add(new UsuarioPremium(4, "Ana Martínez", 15.0));

        EstacionAnclaje e1 = new EstacionAnclaje("Estación Central");
        e1.agregarVehiculo(new Monopatin("ABC123", 80, 450.0, true));
        e1.agregarVehiculo(new Monopatin("DEF456", 10, 450.0, false));
        e1.agregarVehiculo(new BicicletasElectricas("GHI789", 95, 300.0, 5000));

        EstacionAnclaje e2 = new EstacionAnclaje("Estación Norte");
        e2.agregarVehiculo(new Monopatin("JKL012", 60, 450.0, true));
        e2.agregarVehiculo(new BicicletasElectricas("MNO345", 20, 300.0, 3000));

        estaciones.add(e1);
        estaciones.add(e2);
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public List<EstacionAnclaje> getEstaciones() {
        return estaciones;
    }
}