package com.example.MiApiRest.controllers;
import com.example.MiApiRest.entities.Factura;
import com.example.MiApiRest.entities.Pedido;
import com.example.MiApiRest.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends BaseController<Pedido, Long> {
    @Autowired
    private PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService){
        super(pedidoService);
    }


    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<Pedido>> listarPorSucursal(@PathVariable Long idSucursal) throws Exception {
        List<Pedido> pedidos = pedidoService.listarPorSucursal(idSucursal);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Pedido>> listarPorEmpleado(@PathVariable Long idEmpleado) throws Exception {
        List<Pedido> pedidos = pedidoService.listarPorEmpleado(idEmpleado);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long idCliente) throws Exception {
        List<Pedido> pedidos = pedidoService.listarPorCliente(idCliente);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("factura/{idPedido}")
    public Optional<Factura> buscarFacturaPorPedido(@PathVariable Long idPedido)throws Exception{
        Factura factura = pedidoService.buscarFacturaPorPedido(idPedido);
        return Optional.ofNullable(factura);
    }
}
