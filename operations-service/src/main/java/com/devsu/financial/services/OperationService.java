package com.devsu.financial.services;

import com.devsu.financial.model.Account;
import com.devsu.financial.model.Client;
import com.devsu.financial.model.Operation;
import com.devsu.financial.repositories.AccountRepository;
import com.devsu.financial.repositories.OperationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    private final AccountRepository accountRepository;

    public OperationService(OperationRepository operationRepository, AccountRepository accountRepository) {
        this.operationRepository = operationRepository;
        this.accountRepository = accountRepository;
    }

    public Operation createOperation(Long accountId, Operation operation) {

        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new NoSuchElementException("Account not found"));

        double newBalance = account.getInitialBalance() + operation.getAmount();
        if(newBalance < 0){
            throw new NoSuchElementException("Balance not available");
        }

        account.setInitialBalance(newBalance);
        accountRepository.save(account);
        operation.setAccount(account);
        operation.setBalance(newBalance);
        return operationRepository.save(operation);
    }

    public List<Operation> getOperationsByAccountAndDates(Long accountId, LocalDate startDate, LocalDate endDate){

        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new NoSuchElementException("Account not found"));
        return operationRepository.findByAccountAndDateBetween(account, startDate, endDate);
    }

    @RabbitListener(queues = "clientQueue")
    public void handleClienteUpdate(Client client) {
        // Manejar la actualización del cliente
    }
}
