package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.PromocionDetalle;
import com.example.MiApiRest.repositories.BaseRepository;
import com.example.MiApiRest.repositories.PromocionDetalleRepository;
import com.example.MiApiRest.repositories.PromocionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionDetalleService extends BaseService<PromocionDetalle,Long> {
    @Autowired
    private PromocionDetalleRepository promocionDetalleRepository;

    public PromocionDetalleService(PromocionDetalleRepository promocionDetalleRepository){
        super(promocionDetalleRepository);
    }

    @Transactional
    public List<PromocionDetalle> listarPorArticulo(Long idArticulo) throws Exception {
        try {
            return promocionDetalleRepository.findAllByArticuloId(idArticulo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<PromocionDetalle> listarPorPromocion(Long idPromocion) throws Exception {
        try {
            return promocionDetalleRepository.findAllByPromocionId(idPromocion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
