package com.devsu.financial.services;

import com.devsu.financial.model.Cliente;
import com.devsu.financial.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente){
        Cliente existingCliente = clienteRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Cliente no encontrado"));
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setGenero(cliente.getGenero());
        existingCliente.setEdad(cliente.getEdad());
        existingCliente.setIdentificacion(cliente.getIdentificacion());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setTelefono(cliente.getTelefono());
        existingCliente.setContrasena(cliente.getContrasena());
        return clienteRepository.save(existingCliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

}
