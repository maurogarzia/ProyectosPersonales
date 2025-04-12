package com.example.MiApiRest.controllers;

import com.example.MiApiRest.entities.DetallePedido;
import com.example.MiApiRest.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle_pedido")
public class DetallePedidoController extends BaseController<DetallePedido,Long>{
    @Autowired
    private DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService){
        super(detallePedidoService);
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<DetallePedido>> listarPorPedido(@PathVariable Long idPedido)throws Exception{
        List<DetallePedido> detallePedidos = detallePedidoService.listarPorPedido(idPedido);
        return ResponseEntity.ok(detallePedidos);
    }


    @GetMapping("/articulo/{idArticulo}")
    public ResponseEntity<List<DetallePedido>>listarPorArticulo(@PathVariable Long idArticulo)throws Exception{
        List<DetallePedido> detallePedidos = detallePedidoService.listarPorArticulo(idArticulo);
        return ResponseEntity.ok(detallePedidos);
    }
}
