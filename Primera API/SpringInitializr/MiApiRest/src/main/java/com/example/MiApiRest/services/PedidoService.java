package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.Factura;
import com.example.MiApiRest.entities.Pedido;
import com.example.MiApiRest.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService extends BaseService<Pedido, Long> {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        super(pedidoRepository);
    }

    @Transactional
    public List<Pedido> listarPorSucursal(Long idSucursal)throws Exception{
        try {
            return pedidoRepository.findAllBySucursalId(idSucursal);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorEmpleado(Long idEmpleado) throws Exception{
        try {
            return pedidoRepository.findAllByEmpleadoId(idEmpleado);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorCliente(Long idCliente) throws Exception{
        try {
            return pedidoRepository.findAllByClienteId(idCliente);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Factura buscarFacturaPorPedido(Long idPedido)throws Exception{
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido!=null){
                return pedido.getFactura();
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
