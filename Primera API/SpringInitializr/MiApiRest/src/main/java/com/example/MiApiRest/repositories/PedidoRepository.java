package com.example.MiApiRest.repositories;

import com.example.MiApiRest.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    List<Pedido> findAllBySucursalId(Long idSucursal);

    List<Pedido> findAllByEmpleadoId(Long idEmpleado);

    List<Pedido> findAllByClienteId(Long idCliente);
}
