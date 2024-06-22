package com.devsu.financial.repositories;

import com.devsu.financial.model.Account;
import com.devsu.financial.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByAccountAndDateBetween(Account account, LocalDate startDate, LocalDate endDate);

}
