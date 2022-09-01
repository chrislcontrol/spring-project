package com.api.springproject.useCases;

import com.api.springproject.entities.Client;
import com.api.springproject.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {
    final ClientRepository clientRepository;

    public CreateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(String username, String password, String phone, String email) {
        var client = new Client();
        client.setPassword(password);
        client.setEmail(email);
        client.setUsername(username);
        client.setPhone(phone);
        return this.clientRepository.save(client);
    }
}
