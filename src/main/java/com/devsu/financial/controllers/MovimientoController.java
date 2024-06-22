package com.devsu.financial.controllers;

import com.devsu.financial.model.Cuenta;
import com.devsu.financial.model.Movimiento;
import com.devsu.financial.repositories.CuentaRepository;
import com.devsu.financial.repositories.MovimientoRepository;
import com.devsu.financial.services.MovimientoService;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoRepository movimientoRepository;

    private final CuentaRepository cuentaRepository;

    public MovimientoController(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }


    @PostMapping("/{cuentaId}")
    public Movimiento createMovimiento(@PathVariable Long cuentaId, @RequestBody Movimiento movimiento){
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

    @GetMapping
    public List<Movimiento> getMovimientosByCuentaAndFecha(@RequestParam Long cuentaId, @RequestParam LocalDate fechaInicio,
     @RequestParam LocalDate fechaFinal) {
        Cuenta cuenta  = cuentaRepository.findById(cuentaId).orElseThrow(() ->
                new NoSuchElementException("Cuenta no encontrada"));
        return movimientoRepository.findByCuentaAndFechaBetween(cuenta, fechaInicio, fechaFinal);
    }
}
