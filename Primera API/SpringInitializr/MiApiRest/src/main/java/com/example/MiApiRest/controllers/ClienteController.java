package com.example.MiApiRest.controllers;
import com.example.MiApiRest.entities.Cliente;
import com.example.MiApiRest.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends BaseController<Cliente,Long> {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        super(clienteService);
    }


    @GetMapping("domicilio/{idDomicilio}")
    public ResponseEntity<List<Cliente>> listarClientesPorDomicilio(@PathVariable Long idDomicilio) throws Exception {

        List<Cliente> clientes = clienteService.listarClientesPorDomicilio(idDomicilio);
        return ResponseEntity.ok(clientes);
    }
}