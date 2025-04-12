package com.example.MiApiRest.services;


import com.example.MiApiRest.entities.ArticuloManufacturadoDetalle;
import com.example.MiApiRest.repositories.ArticuloManufacturadoDetalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoDetalleService extends BaseService<ArticuloManufacturadoDetalle,Long>{
    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository){
        super(articuloManufacturadoDetalleRepository);
    }


    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloInsumo(Long idArticuloInsumo)throws Exception{
        try {
            return articuloManufacturadoDetalleRepository.findAllByArticuloInsumoId(idArticuloInsumo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloManufacturado(Long idAticuloManufacturado)throws Exception{
        try {
            return articuloManufacturadoDetalleRepository.findAllByArticuloManufacturadoId(idAticuloManufacturado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
