package com.example.services;

import org.springframework.stereotype.Service;
import com.example.Exception.BateriaInsuficienteException;
import com.example.Exception.VehiculoNoEncontradoException;
import com.example.factory.ProcesadorPagoFactory;
import com.example.models.EstacionAnclaje;
import com.example.models.ProcesadorPago;
import com.example.models.Usuario;
import com.example.models.Vehiculo;
import com.example.repository.EcoRideRepository;
import java.util.List;

@Service
public class AlquilerService {

    private static final int BATERIA_MINIMA = 15;
    private final EcoRideRepository repository;

    public AlquilerService(EcoRideRepository repository) {
        this.repository = repository;
    }

    public String desbloquear(int idUsuario, String patente, String metodoPago) {
        Vehiculo vehiculo = buscarVehiculoEnEstaciones(patente);
        validarBateria(vehiculo);
        Usuario usuario = repository.buscarUsuarioPorId(idUsuario);
        double montoFinal = calcularMonto(vehiculo, usuario);
        ProcesadorPago procesador = ProcesadorPagoFactory.obtenerProcesador(metodoPago);
        procesador.cobrar(montoFinal);
        return String.format(
            "Rodado desbloqueado. Vehículo: %s | Usuario: %s | Monto: $%.2f | Pago: %s.",
            vehiculo.getPatente(),
            usuario != null ? usuario.getNombreCompleto() : "Desconocido",
            montoFinal,
            metodoPago
        );
    }

    private Vehiculo buscarVehiculoEnEstaciones(String patente) {
        List<EstacionAnclaje> estaciones = repository.getEstaciones();
        for (EstacionAnclaje estacion : estaciones) {
            Vehiculo encontrado = estacion.buscarVehiculoPatente(patente);
            if (encontrado != null) return encontrado;
        }
        throw new VehiculoNoEncontradoException(patente);
    }

    private void validarBateria(Vehiculo vehiculo) {
        if (vehiculo.getPorcentajeBateria() < BATERIA_MINIMA) {
            throw new BateriaInsuficienteException(vehiculo.getPorcentajeBateria());
        }
    }

    private double calcularMonto(Vehiculo vehiculo, Usuario usuario) {
        double tarifa = vehiculo.getTarifaBase();
        if (usuario != null) return usuario.aplicarDescuento(tarifa);
        return tarifa;
    }
}