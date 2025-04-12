package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Domicilio;
import com.example.MiApiRest.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService extends BaseService<Domicilio,Long>{
    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioService(DomicilioRepository domicilioRepository){
        super(domicilioRepository);
    }

    @Transactional
    public List<Domicilio> listarPorLocalidad(Long idLocalidad)throws Exception{
        try {
            return domicilioRepository.findAllByLocalidadId(idLocalidad);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
