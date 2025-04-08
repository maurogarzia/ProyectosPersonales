package com.example.MiApiRest.repositories;
import com.example.MiApiRest.entities.Empleado;
import com.example.MiApiRest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}

