package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Cliente;
import com.example.MiApiRest.repositories.BaseRepository;
import com.example.MiApiRest.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente, Long> {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        super(clienteRepository);
    }

    @Transactional
    public List<Cliente> listarClientesPorDomicilio(Long idDomicilio)throws Exception{
        try {
            return clienteRepository.findAllByDomicilioId(idDomicilio);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
