package com.example.MiApiRest.services;

import com.example.MiApiRest.entities.DetallePedido;
import com.example.MiApiRest.repositories.DetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService extends BaseService<DetallePedido,Long>{
    @Autowired
    DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository){
        super(detallePedidoRepository);
    }

    @Transactional
    public List<DetallePedido> listarPorPedido (Long idPedido)throws Exception{
        try {
            return detallePedidoRepository.findAllByPedidoId(idPedido);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public List<DetallePedido> listarPorArticulo (Long idArticulo)throws Exception{
        try {
            return detallePedidoRepository.findAllByArticuloId(idArticulo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
