package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Categoria;
import com.example.MiApiRest.entities.Promocion;
import com.example.MiApiRest.entities.Sucursal;
import com.example.MiApiRest.repositories.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalService extends BaseService<Sucursal,Long>{
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository){
        super(sucursalRepository);
    }

    @Transactional
    public List<Categoria> listarCategoriaPorSucursal(Long idSucursal) throws Exception{
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            return new ArrayList<>(sucursal.getCategorias());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public List<Promocion> listarPromocionesPorSucursal(Long idSucursal)throws Exception{
        try {
            Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
            return new ArrayList<>(sucursal.getPromociones());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public List<Sucursal> listarSucursalesPorEmpresa (Long idEmpresa) throws Exception {
        try {
            return sucursalRepository.findAllByEmpresaId(idEmpresa);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
