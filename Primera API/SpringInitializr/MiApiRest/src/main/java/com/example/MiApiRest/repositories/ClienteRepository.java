package com.example.MiApiRest.repositories;
import com.example.MiApiRest.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{
    List<Cliente> findAllByDomicilioId(Long idDomicilio);
}
