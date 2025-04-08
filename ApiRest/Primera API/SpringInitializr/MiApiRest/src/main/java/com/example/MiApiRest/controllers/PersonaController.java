package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Persona;
import com.example.MiApiRest.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;


}
