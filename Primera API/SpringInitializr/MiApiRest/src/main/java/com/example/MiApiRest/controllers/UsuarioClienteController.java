package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.UsuarioCliente;
import com.example.MiApiRest.services.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario_cliente")
public class UsuarioClienteController extends BaseController<UsuarioCliente,Long>{
    public UsuarioClienteController(UsuarioClienteService usuarioClienteService){
        super(usuarioClienteService);
    }
}
