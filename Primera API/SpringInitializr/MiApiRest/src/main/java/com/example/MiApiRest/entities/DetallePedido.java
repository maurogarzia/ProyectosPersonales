package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "detalle_pedido")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends Base implements Serializable {
    @Column
    private Integer cantidad;
    @Column
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;

}
