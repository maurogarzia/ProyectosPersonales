package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.Base;
import com.example.MiApiRest.entities.Categoria;
import com.example.MiApiRest.entities.Promocion;
import com.example.MiApiRest.entities.Sucursal;
import com.example.MiApiRest.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController extends BaseController<Sucursal,Long> {
    @Autowired
    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        super(sucursalService);
    }

    @GetMapping("categoria/{idSucursal}")
    public ResponseEntity<List<Categoria>> listarCategoriasPorSucursal(@PathVariable Long idSucursal)throws Exception{
        List<Categoria> categorias = sucursalService.listarCategoriaPorSucursal(idSucursal);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("promocion/{idSucursal}")
    public ResponseEntity<List<Promocion>> listarPromocionesPorSucursal(@PathVariable Long idSucursal) throws Exception {
        List<Promocion> promociones = sucursalService.listarPromocionesPorSucursal(idSucursal);
        return ResponseEntity.ok(promociones);
    }

    @GetMapping("empresa/{idEmpresa}")
    public ResponseEntity<List<Sucursal>> listarSucursalesPorEmpresa(@PathVariable Long idEmpresa) throws Exception {
        List<Sucursal> sucursales = sucursalService.listarSucursalesPorEmpresa(idEmpresa);
        return ResponseEntity.ok(sucursales);
    }
}
