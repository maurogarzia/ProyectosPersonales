package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Domicilio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long>{
    List<Domicilio> findAllByLocalidadId(Long idLocalidad);
}
