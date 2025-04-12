package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Base;
import com.example.MiApiRest.entities.PromocionDetalle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long> {
    List<PromocionDetalle> findAllByArticuloId(Long idArticulo);

    List<PromocionDetalle> findAllByPromocionId(Long idPromocion);
}
