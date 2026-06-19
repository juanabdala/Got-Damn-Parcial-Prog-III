package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.models.BicicletasElectricas;
import com.example.models.EstacionAnclaje;
import com.example.models.Monopatin;
import com.example.models.Usuario;
import com.example.models.UsuarioPremium;
import com.example.models.UsuarioRegular;
import com.example.models.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.models.CoordenadaGPS;
import java.util.LinkedHashSet;
import java.util.Set;

@Repository
public class EcoRideRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<EstacionAnclaje> estaciones = new ArrayList<>();

    private final Map<String, Vehiculo> vehiculosPorPatente = new HashMap<>();

    public EcoRideRepository() {
        cargarDatos();
    }

    private void cargarDatos() {
        usuarios.add(new UsuarioRegular(1, "Juan Pérez"));
        usuarios.add(new UsuarioRegular(2, "María García"));
        usuarios.add(new UsuarioPremium(3, "Carlos López", 10.0));
        usuarios.add(new UsuarioPremium(4, "Ana Martínez", 15.0));

        EstacionAnclaje e1 = new EstacionAnclaje("Estación Central");
        registrarVehiculo(e1, new Monopatin("ABC123", 80, 450.0, true));
        registrarVehiculo(e1, new Monopatin("DEF456", 10, 450.0, false));
        registrarVehiculo(e1, new BicicletasElectricas("GHI789", 95, 300.0, 5000));

        EstacionAnclaje e2 = new EstacionAnclaje("Estación Norte");
        registrarVehiculo(e2, new Monopatin("JKL012", 60, 450.0, true));
        registrarVehiculo(e2, new BicicletasElectricas("MNO345", 20, 300.0, 3000));

        estaciones.add(e1);
        estaciones.add(e2);
    }

    private void registrarVehiculo(EstacionAnclaje estacion, Vehiculo vehiculo) {
        estacion.agregarVehiculo(vehiculo);
        vehiculosPorPatente.put(vehiculo.getPatente().toUpperCase(), vehiculo);
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        if (patente == null) {
            return null;
        }
        return vehiculosPorPatente.get(patente.toUpperCase());
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculosPorPatente.values());
    }

    public Set<CoordenadaGPS> deduplicarReportesGPS(List<CoordenadaGPS> reportes) {
        Set<CoordenadaGPS> unicos = new LinkedHashSet<>();
        for (CoordenadaGPS reporte : reportes) {
            unicos.add(reporte);
        }
        return unicos;
    }

    public List<EstacionAnclaje> getEstaciones() {
        return estaciones;
    }
}