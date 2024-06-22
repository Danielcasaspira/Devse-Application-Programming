package com.devsu.financial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private String numberAccount;

    private String typeAccount;

    private double initialBalance;

    private boolean status;

    private Long clientId;

}
