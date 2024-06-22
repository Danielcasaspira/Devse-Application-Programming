package com.devsu.financial.services;

import com.devsu.financial.model.Cliente;
import com.devsu.financial.model.Cuenta;
import com.devsu.financial.model.CuentaRequest;
import com.devsu.financial.repositories.ClienteRepository;
import com.devsu.financial.repositories.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    private final ClienteRepository clienteRepository;


    public CuentaService(CuentaRepository cuentaRepository, ClienteRepository clienteRepository) {
        this.cuentaRepository = cuentaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Cuenta createCuenta(CuentaRequest cuentaRequest){
        Cliente cliente = clienteRepository.findById(cuentaRequest.getClienteId())
                .orElseThrow(() -> new NoSuchElementException("Cliente not encontrado, por favor especifique uno existente"));

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(cuentaRequest.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaRequest.getSaldoInicial());
        cuenta.setEstado(cuentaRequest.isEstado());
        cuenta.setCliente(cliente);

        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuenta){
        Cuenta existingCuenta = cuentaRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Cuenta no encontrada"));
        existingCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        existingCuenta.setTipoCuenta(cuenta.getTipoCuenta());
        existingCuenta.setSaldoInicial(cuenta.getSaldoInicial());
        existingCuenta.setEstado(cuenta.isEstado());
        return cuentaRepository.save(existingCuenta);
    }

    public void deleteCuenta(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cuenta not found"));
        cuentaRepository.delete(cuenta);
    }

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

}
