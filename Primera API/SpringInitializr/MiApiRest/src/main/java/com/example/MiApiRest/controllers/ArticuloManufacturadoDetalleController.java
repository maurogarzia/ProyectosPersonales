package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.ArticuloManufacturado;
import com.example.MiApiRest.entities.ArticuloManufacturadoDetalle;
import com.example.MiApiRest.services.ArticuloManufacturadoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
@RequestMapping(value = "articulo-manufacturado-detalle")
public class ArticuloManufacturadoDetalleController extends BaseController<ArticuloManufacturadoDetalle,Long>{
    @Autowired
    private ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService;

    private ArticuloManufacturadoDetalleController(ArticuloManufacturadoDetalleService articuloManufacturadoDetalleService){
        super(articuloManufacturadoDetalleService);
    }


    @GetMapping("/articulo-insumo/{idArticuloInsumo}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticuloInsumo(Long idArticuloInsumo) throws Exception {
        List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = articuloManufacturadoDetalleService.listarPorArticuloInsumo(idArticuloInsumo);
        return ResponseEntity.ok(articuloManufacturadoDetalles);
    }

    @GetMapping("/articulo-manufacturado/{idArticuloManufacturado}")
    public ResponseEntity<List<ArticuloManufacturadoDetalle>> listarPorArticuloManufacturado(Long idArticuloManufacturado) throws Exception {
        List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = articuloManufacturadoDetalleService.listarPorArticuloManufacturado(idArticuloManufacturado);
        return ResponseEntity.ok(articuloManufacturadoDetalles);
    }
}
