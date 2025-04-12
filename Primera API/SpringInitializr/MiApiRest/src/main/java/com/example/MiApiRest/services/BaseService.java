package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Base;
import com.example.MiApiRest.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.security.Escape;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseService <E extends Base, ID extends Serializable>  {
    @Autowired
    protected BaseRepository<E,ID> baseRepository;

    public BaseService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }


    //Crear entidad
    @Transactional
    public E crearEntidad( E entity) throws Exception{
        try{
            return baseRepository.save(entity);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    //Listar entidad
    @Transactional
    public List<E>listar() throws Exception {
        try {
            return baseRepository.findAll();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
    //Buscar entidad por id
    @Transactional
    public Optional<E> buscarEntidadPorId(ID id) throws Exception {
        try{
            return Optional.ofNullable(baseRepository.findById(id).orElse(null));
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    //Actualizar entidad
    @Transactional
    public E actualizarEntidad(E entity) throws Exception {
        try {
            return baseRepository.save(entity);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
    //Eliminar entidad
    @Transactional
    public void eliminarEntidad(ID id) throws Exception {
        try {
            baseRepository.deleteById(id);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
}
