package com.devsu.financial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequest {

    private String numeroCuenta;

    private String tipoCuenta;

    private double saldoInicial;

    private boolean estado;

    private Long clienteId;

}
