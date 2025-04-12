package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Base;
import com.example.MiApiRest.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController <E extends Base, ID extends Serializable> {
    protected BaseService<E, ID> service;

    public BaseController(BaseService<E, ID> service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<E>> listar() throws Exception{
        List<E>entities = service.listar();
        return ResponseEntity.ok(entities);
    }
    @GetMapping("/{id}")
    public Optional<E> buscarEntidadPorId(@PathVariable ID id) throws Exception{
        return service.buscarEntidadPorId(id);
    }
    @PostMapping()
    public ResponseEntity<E> crearEntidad(@RequestBody E entity) throws Exception{
        E entidadAct = service.crearEntidad(entity);
        return ResponseEntity.ok(entidadAct);
    }
    @PutMapping()
    public ResponseEntity<E> actualizarEntidad(@RequestBody E entity) throws Exception{
        E entidadAct = service.actualizarEntidad(entity);
        return ResponseEntity.ok(entidadAct);
    }
    @DeleteMapping("/{id}")
    public void eliminarEntidad(@PathVariable ID id)throws Exception{
        service.eliminarEntidad(id);
    }
}
