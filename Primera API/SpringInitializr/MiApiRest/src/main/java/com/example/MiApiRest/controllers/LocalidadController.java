package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Localidad;
import com.example.MiApiRest.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidad")
public class LocalidadController extends BaseController<Localidad,Long>{
    @Autowired
    private LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService){
        super(localidadService);
    }

    @GetMapping("/provincia/{idProvincia}")
    public ResponseEntity<List<Localidad>> listarPorProvincia(@PathVariable Long idProvincia)throws Exception{
        List<Localidad> localidades = localidadService.listarPorProvincia(idProvincia);
        return ResponseEntity.ok(localidades);
    }
}
