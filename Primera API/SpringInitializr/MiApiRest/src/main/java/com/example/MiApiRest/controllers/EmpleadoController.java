package com.example.MiApiRest.controllers;
import com.example.MiApiRest.entities.Empleado;
import com.example.MiApiRest.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController extends BaseController<Empleado,Long> {
    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        super(empleadoService);
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<Empleado>> listarPorSucursal(@PathVariable Long idSucursal)throws Exception{
        List<Empleado> empleados = empleadoService.listarPorSucursal(idSucursal);
        return ResponseEntity.ok(empleados);
    }
}
