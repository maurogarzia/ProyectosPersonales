package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.ImagenCliente;

import com.example.MiApiRest.services.ImagenClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagen_cliente")
public class ImagenClienteController extends BaseController<ImagenCliente,Long>{
    public ImagenClienteController(ImagenClienteService imagenClienteService){
        super(imagenClienteService);
    }
}
