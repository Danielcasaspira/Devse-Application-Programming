package com.devsu.financial.repositories;

import com.devsu.financial.model.Cuenta;
import com.devsu.financial.model.Movimiento;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaAndFechaBetween(Cuenta cuenta, LocalDate fechaInicio, LocalDate finalFinal);

}
