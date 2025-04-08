package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Cliente;
import com.example.MiApiRest.entities.Persona;
import com.example.MiApiRest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Persona> listarCliente(){
        return clienteRepository.findAll();
    }

}
