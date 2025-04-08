package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Empleado;
import com.example.MiApiRest.entities.Persona;
import com.example.MiApiRest.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    public Empleado crearEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public List<Persona> listarEmpleado(){
        return empleadoRepository.findAll();
    }

    public Empleado actualizarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

}
