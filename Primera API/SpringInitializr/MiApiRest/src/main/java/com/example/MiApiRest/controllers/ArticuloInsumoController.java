package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.ArticuloInsumo;
import com.example.MiApiRest.services.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articulo-insumo")
public class ArticuloInsumoController extends BaseController<ArticuloInsumo,Long>{
    public ArticuloInsumoController(ArticuloInsumoService articuloInsumoService){
        super(articuloInsumoService);
    }
}
