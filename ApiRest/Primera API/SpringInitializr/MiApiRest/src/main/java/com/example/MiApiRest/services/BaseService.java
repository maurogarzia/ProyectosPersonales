package com.example.MiApiRest.services;
import com.example.MiApiRest.entities.Persona;
import jdk.jfr.Experimental;

import java.util.List;


public interface BaseService<E> {
    public Persona crearPersona(Persona persona) throws Exception;

    public Persona buscarPersonaPorId(Long id) throws Exception;

    public List<Persona>listarPersona() throws Exception;

    public Persona actualizarPersona(Persona persona) throws Exception;

    public void eliminarPersona(Long id) throws Exception;


}
