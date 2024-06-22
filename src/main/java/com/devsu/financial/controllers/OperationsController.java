package com.devsu.financial.controllers;

import com.devsu.financial.model.Account;
import com.devsu.financial.model.Operation;
import com.devsu.financial.repositories.AccountRepository;
import com.devsu.financial.repositories.OperationRepository;
import com.devsu.financial.services.OperationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private final OperationService operationService;

    public OperationsController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/{accountId}")
    public Operation createOperation(@PathVariable Long accountId, @RequestBody Operation operation){
       return operationService.createOperation(accountId, operation);
    }

    @GetMapping
    public List<Operation> getOperationsByAccountAndDates(@RequestParam Long accountId, @RequestParam LocalDate startDate,
                                                          @RequestParam LocalDate endDate) {
        return operationService.getOperationsByAccountAndDates(accountId, startDate, endDate);
    }
}
