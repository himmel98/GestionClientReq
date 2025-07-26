package com.gestionClient.controller;

import com.gestionClient.model.Client;
import com.gestionClient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    // Ajouter un nouveau client (POST)
    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        client.setId(0); // Important pour éviter le problème de mise à jour
        return ResponseEntity.ok(clientService.saveClient(client));
    }

    // Récupérer tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Récupérer un client par ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Mettre à jour un client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client clientDetails) {
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()) {
            clientDetails.setId(id);
            Client updatedClient = clientService.updateClient(clientDetails);
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id) {
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()) {
            clientService.deleteClient(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Rechercher par ville
    @GetMapping("/ville/{ville}")
    public ResponseEntity<List<Client>> getClientsByVille(@PathVariable String ville) {
        List<Client> clients = clientService.getClientsByVille(ville);
        return ResponseEntity.ok(clients);
    }
    //Rechercher par nom
    @GetMapping("/nom/{nom}")
    public ResponseEntity<List<Client>> getClientsByNom(@PathVariable String nom) {
        return ResponseEntity.ok(clientService.getClientsByNom(nom));
    }
    //Compter les clients par ville
    @GetMapping("/ville/{ville}/count")
    public ResponseEntity<Long> countClientsByVille(@PathVariable String ville) {
        return ResponseEntity.ok(clientService.countClientsByVille(ville));
    }

}
