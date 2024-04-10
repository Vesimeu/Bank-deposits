package com.example.bankdeposit.service;

import com.example.bankdeposit.model.Client;
import com.example.bankdeposit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        return clientOptional.orElse(null);
    }

    public List<Client> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        System.out.println("Список всех клиентов из базы данных: " + clients);
        return clients;
    }
    

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long clientId, Client clientDetails) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client existingClient = clientOptional.get();
            existingClient.setName(clientDetails.getName());
            existingClient.setShortName(clientDetails.getShortName());
            existingClient.setAddress(clientDetails.getAddress());
            existingClient.setLegalForm(clientDetails.getLegalForm());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    public boolean deleteClientById(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
            return true;
        } else {
            return false;
        }
    }
}
