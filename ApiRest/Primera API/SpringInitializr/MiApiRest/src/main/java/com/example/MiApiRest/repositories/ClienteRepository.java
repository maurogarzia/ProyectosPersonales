package com.example.MiApiRest.repositories;
import com.example.MiApiRest.entities.Cliente;
import com.example.MiApiRest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
