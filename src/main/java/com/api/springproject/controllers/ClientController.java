package com.api.springproject.controllers;

import com.api.springproject.entities.Client;
import com.api.springproject.useCases.CreateClientUseCase;
import dtos.CreateClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("clients")
public class ClientController {
    final CreateClientUseCase createClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping
    public ResponseEntity<Client> post(@RequestBody @Valid CreateClientDTO createClientDTO) {
        Client client = this.createClientUseCase.createClient(
                createClientDTO.getUsername(),
                createClientDTO.getPassword(),
                createClientDTO.getPhone(),
                createClientDTO.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}
