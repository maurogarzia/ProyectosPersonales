package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Localidad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long>{
    List<Localidad> findAllByProvinciaId(Long idProvincia);
}
