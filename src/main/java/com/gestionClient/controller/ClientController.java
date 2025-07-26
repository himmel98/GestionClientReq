package com.gestionClient.controller;

import com.gestionClient.model.Client;
import com.gestionClient.model.Orders;
import com.gestionClient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public Client addClient(@RequestBody Client c) { return service.addClient(c); }

    @GetMapping
    public List<Client> getAllClients() { return service.getAllClients(); }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable Long id) { return service.getClient(id); }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) { service.deleteClient(id); }

    @GetMapping("/{id}/orders")
    public List<Orders> getOrdersByClientId(@PathVariable Long id) {
        return service.getOrdersByClientId(id);
    }
}
