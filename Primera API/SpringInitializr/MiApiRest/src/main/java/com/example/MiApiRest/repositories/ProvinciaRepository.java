package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Provincia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia,Long>{
    List<Provincia> findAllByPaisId(Long idPais);
}
