package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.ImagenCliente;

import com.example.MiApiRest.repositories.ImagenClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenClienteService extends BaseService<ImagenCliente,Long>{
    @Autowired
    ImagenClienteService(ImagenClienteRepository imagenClienteRepository){
        super(imagenClienteRepository);
    }
}
