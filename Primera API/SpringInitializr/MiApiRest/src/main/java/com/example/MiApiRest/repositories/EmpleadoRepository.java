package com.example.MiApiRest.repositories;


import com.example.MiApiRest.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long>{
    List<Empleado> findAllBySucursalId(Long idSucursal);

}

