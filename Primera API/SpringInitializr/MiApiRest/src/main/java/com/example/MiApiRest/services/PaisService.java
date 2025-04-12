package com.example.MiApiRest.services;


import com.example.MiApiRest.entities.Pais;
import com.example.MiApiRest.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PaisService extends BaseService <Pais,Long>{
    @Autowired
    public PaisService (PaisRepository paisRepository){
        super(paisRepository);
    }

}
