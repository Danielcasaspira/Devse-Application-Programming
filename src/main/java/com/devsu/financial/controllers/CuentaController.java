package com.devsu.financial.controllers;

import com.devsu.financial.model.Cuenta;
import com.devsu.financial.model.CuentaRequest;
import com.devsu.financial.services.CuentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;

    }

    @GetMapping
    public List<Cuenta> getAllCuentas(){
        return cuentaService.getAllCuentas();
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody CuentaRequest cuentaRequest){
        return cuentaService.createCuenta(cuentaRequest);
    }

    @PutMapping("/{id}")
    public Cuenta updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta){
        return cuentaService.updateCuenta(id, cuenta);
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id){
        cuentaService.deleteCuenta(id);
    }
}
