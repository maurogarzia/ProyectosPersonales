package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.PromocionDetalle;
import com.example.MiApiRest.services.PromocionDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promocion_detalle")
public class PromocionDetalleController extends BaseController<PromocionDetalle,Long> {
    @Autowired
    private PromocionDetalleService promocionDetalleService;
    public PromocionDetalleController(PromocionDetalleService promocionDetalleService){
        super(promocionDetalleService);
    }

    @GetMapping("/articulo/{idArticulo}")
    public ResponseEntity<List<PromocionDetalle>> listarPorArticulo(@PathVariable Long idArticulo) throws Exception {
        List<PromocionDetalle> promocionDetalles = promocionDetalleService.listarPorArticulo(idArticulo);
        return ResponseEntity.ok(promocionDetalles);
    }

    @GetMapping("/promocion/{idPromocion}")
    public ResponseEntity<List<PromocionDetalle>> listarPorPromocion(@PathVariable Long idPromocion) throws Exception {
        List<PromocionDetalle> promocionDetalles = promocionDetalleService.listarPorPromocion(idPromocion);
        return ResponseEntity.ok(promocionDetalles);
    }
}

