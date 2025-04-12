package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Domicilio;
import com.example.MiApiRest.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController extends BaseController<Domicilio,Long>{
    @Autowired
    private DomicilioService domicilioService;

    public DomicilioController(DomicilioService domicilioService){
        super(domicilioService);
    }


    @GetMapping("/localidad/{idLocalidad}")
    public ResponseEntity<List<Domicilio>> listarPorLocalidad(@PathVariable Long idLocalidad) throws Exception {
        List<Domicilio> domicilios = domicilioService.listarPorLocalidad(idLocalidad);
        return ResponseEntity.ok(domicilios);
    }
}
