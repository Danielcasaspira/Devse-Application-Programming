package com.devsu.financial.services;

import com.devsu.financial.model.Cuenta;
import com.devsu.financial.model.Movimiento;
import com.devsu.financial.repositories.CuentaRepository;
import com.devsu.financial.repositories.MovimientoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    private final CuentaRepository cuentaRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Movimiento createMovimiento(Long cuentaId, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() ->
                new NoSuchElementException("Cuenta no encontrada"));
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if(nuevoSaldo < 0){
            throw new NoSuchElementException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);
        movimiento.setCuenta(cuenta);
        movimiento.setSaldo(nuevoSaldo);
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> getMovimientosByCuentaAndFecha(Long cuentaId, LocalDate fechaInicio, LocalDate fechaFinal){
        Cuenta cuenta  = cuentaRepository.findById(cuentaId).orElseThrow(() ->
                new NoSuchElementException("Cuenta no encontrada"));
        return movimientoRepository.findByCuentaAndFechaBetween(cuenta, fechaInicio, fechaFinal);
    }
}
