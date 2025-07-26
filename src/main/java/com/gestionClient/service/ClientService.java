package com.gestionClient.service;

import com.gestionClient.model.Client;
import com.gestionClient.model.Orders;
import com.gestionClient.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client) { return clientRepository.save(client); }
    public List<Client> getAllClients() { return clientRepository.findAll(); }
    public Optional<Client> getClient(Long id) { return clientRepository.findById(id); }
    public void deleteClient(Long id) { clientRepository.deleteById(id); }

    public List<Orders> getOrdersByClientId(Long clientId) {
        return clientRepository.findById(clientId).map(Client::getOrders).orElse(Collections.emptyList());
    }
}
