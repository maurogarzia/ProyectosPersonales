package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends BaseRepository<Sucursal,Long>{
    List<Sucursal> findAllByEmpresaId(Long id);

}
