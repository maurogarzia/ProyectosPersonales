package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Persona;
import com.example.MiApiRest.repositories.PersonaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService implements BaseService<Persona>{

    @Autowired //Inyecta la dependencia
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public Persona buscarPersonaPorId(Long id){
        return personaRepository.findById(id).orElse(null); //La propiedad orElse devuelve null si falla
    }

    @Override
    @Transactional
    public List<Persona>listarPersona(){
        return personaRepository.findAll();
    }

    @Override
    @Transactional
    public Persona actualizarPersona(Persona persona){
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void eliminarPersona(Long id){
        personaRepository.deleteById(id); //Elimino el id de la persona en cuestion
    }



}
