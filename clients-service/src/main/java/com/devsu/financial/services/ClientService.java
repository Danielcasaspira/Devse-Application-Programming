package com.devsu.financial.services;

import com.devsu.financial.model.Client;
import com.devsu.financial.repositories.ClientRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final RabbitTemplate rabbitTemplate;

    public ClientService(ClientRepository clientRepository, RabbitTemplate rabbitTemplate) {
        this.clientRepository = clientRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client){

        Client existingClient = clientRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Client not found"));

        existingClient.setName(client.getName());
        existingClient.setGender(client.getGender());
        existingClient.setAge(client.getAge());
        existingClient.setIdentification(client.getIdentification());
        existingClient.setAddress(client.getAddress());
        existingClient.setPhone(client.getPhone());
        existingClient.setPassword(client.getPassword());
        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void notifyAccountService(Client client) {
        rabbitTemplate.convertAndSend("clientQueue", client);
    }

}
