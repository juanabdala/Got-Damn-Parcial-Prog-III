package com.example.services;

import org.springframework.stereotype.Service;

import com.example.Exception.BateriaInsuficienteException;
import com.example.Exception.VehiculoNoEncontradoException;
import com.example.dto.RespuestaAlquilerDTO;
import com.example.factory.ProcesadorPagoFactory;
import com.example.models.ProcesadorPago;
import com.example.models.Usuario;
import com.example.models.Vehiculo;
import com.example.models.Tarifa.EstrategiaTarifa;
import com.example.models.Tarifa.TarifaEstandar;
import com.example.repository.EcoRideRepository;

@Service
public class AlquilerService {

    private static final int BATERIA_MINIMA = 15;

    private final EcoRideRepository repository;
    private EstrategiaTarifa estrategiaTarifa = new TarifaEstandar(); 

    public AlquilerService(EcoRideRepository repository) {
        this.repository = repository;
    }

    
    public void setEstrategiaTarifa(EstrategiaTarifa estrategiaTarifa) {
        this.estrategiaTarifa = estrategiaTarifa;
    }

    
    public RespuestaAlquilerDTO desbloquear(int idUsuario, String patente) {
        Vehiculo vehiculo = repository.buscarVehiculoPorPatente(patente); 
        if (vehiculo == null) {
            throw new VehiculoNoEncontradoException(patente);
        }
        if (vehiculo.getPorcentajeBateria() < BATERIA_MINIMA) {
            throw new BateriaInsuficienteException(vehiculo.getPorcentajeBateria());
        }
        vehiculo.iniciarViaje(); 

        return new RespuestaAlquilerDTO(
            vehiculo.getPatente(),
            0.0,
            0,
            vehiculo.getEstado().getNombre()
        );
    }

   
    public RespuestaAlquilerDTO finalizar(int idUsuario, String patente, int minutos, String metodoPago) {
        Vehiculo vehiculo = repository.buscarVehiculoPorPatente(patente); // O(1)
        if (vehiculo == null) {
            throw new VehiculoNoEncontradoException(patente);
        }
        vehiculo.finalizarViaje(); 

        double costoBruto = estrategiaTarifa.calcular(minutos, vehiculo.getTarifaBase());

        Usuario usuario = repository.buscarUsuarioPorId(idUsuario);
        double costoFinal = (usuario != null) ? usuario.aplicarDescuento(costoBruto) : costoBruto;

        ProcesadorPago procesador = ProcesadorPagoFactory.obtenerProcesador(metodoPago);
        procesador.cobrar(costoFinal);

        return new RespuestaAlquilerDTO(
            vehiculo.getPatente(),
            costoFinal,
            minutos,
            vehiculo.getEstado().getNombre()
        );
    }
}