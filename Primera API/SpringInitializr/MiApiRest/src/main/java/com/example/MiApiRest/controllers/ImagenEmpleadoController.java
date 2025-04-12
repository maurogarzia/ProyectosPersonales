package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.ImagenEmpleado;
import com.example.MiApiRest.services.ImagenEmpleadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagen_empleado")
public class ImagenEmpleadoController extends BaseController<ImagenEmpleado,Long>{
    public ImagenEmpleadoController(ImagenEmpleadoService imagenEmpleadoService) {
       super(imagenEmpleadoService);
    }
}

