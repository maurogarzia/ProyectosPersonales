package com.example.MiApiRest.services;


import com.example.MiApiRest.entities.Imagen;
import com.example.MiApiRest.entities.ImagenEmpleado;
import com.example.MiApiRest.repositories.ImagenEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenEmpleadoService extends BaseService<ImagenEmpleado,Long>{
    @Autowired
    ImagenEmpleadoService(ImagenEmpleadoRepository imagenEmpleadoRepository){
        super(imagenEmpleadoRepository);
    }
}
