package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Provincia;
import com.example.MiApiRest.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController extends BaseController<Provincia,Long>{
    @Autowired
    private ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService){
        super(provinciaService);
    }

    @GetMapping("/pais/{idPais}")
    public ResponseEntity<List<Provincia>> listarPorPais(@PathVariable Long idPais) throws Exception {
        List<Provincia> provincias = provinciaService.listarPorPais(idPais);
        return ResponseEntity.ok(provincias);
    }
}
