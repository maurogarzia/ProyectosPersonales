package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRespository extends BaseRepository<Categoria,Long>{
    List<Categoria> findAllByCategoriaPadre_Id(Long idCategoriaPadre);
}
