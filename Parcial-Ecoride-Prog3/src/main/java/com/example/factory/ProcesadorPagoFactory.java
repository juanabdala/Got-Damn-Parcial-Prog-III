package com.example.factory;

import com.example.models.BilleteraVirtual;
import com.example.models.ProcesadorPago;
import com.example.models.TarjetaCredito;

public class ProcesadorPagoFactory {

    public static ProcesadorPago obtenerProcesador(String metodoPago) {
        if (metodoPago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo.");
        }
        switch (metodoPago.toUpperCase()) {
            case "TARJETA":   return new TarjetaCredito();
            case "BILLETERA": return new BilleteraVirtual();
            default: throw new IllegalArgumentException("Método de pago no reconocido: " + metodoPago);
        }
    }
}