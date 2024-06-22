package com.devsu.financial.services;

import com.devsu.financial.model.Client;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ClientConsumer {

    private final ConcurrentHashMap<Long, Client> clientCache = new ConcurrentHashMap<>();

    @RabbitListener(queues = "clientQueue")
    public void handleClientUpdate(Client client) {
        clientCache.put(client.getId(), client);
    }

    public Client getClient(Long clientId) {
        return clientCache.get(clientId);
    }

}
