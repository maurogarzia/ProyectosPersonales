package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Empleado;
import com.example.MiApiRest.entities.Persona;
import com.example.MiApiRest.services.EmpleadoService;
import com.example.MiApiRest.services.PersonaService;
import org.hibernate.sql.results.graph.embeddable.EmbeddableLoadingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.security.PrivateKey;
import java.util.List;

@RestController

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;
}
