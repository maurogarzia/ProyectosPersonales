package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.UsuarioCliente;
import com.example.MiApiRest.repositories.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteService extends BaseService<UsuarioCliente,Long>{
    @Autowired
    UsuarioClienteService(UsuarioClienteRepository usuarioClienteRepository){
        super(usuarioClienteRepository);
    }
}
