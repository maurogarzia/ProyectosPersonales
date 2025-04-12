package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Provincia;
import com.example.MiApiRest.repositories.PaisRepository;
import com.example.MiApiRest.repositories.ProvinciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService extends BaseService<Provincia,Long>{
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository){
        super(provinciaRepository);
    }

    @Transactional
    public List<Provincia> listarPorPais(Long idPais) throws Exception {
        try {
            return provinciaRepository.findAllByPaisId(idPais);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
