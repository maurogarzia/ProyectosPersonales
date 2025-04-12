package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "detalle_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ArticuloManufacturadoDetalle extends Base implements Serializable {

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    @JoinColumn(name = "articulo_insumo")
    private ArticuloInsumo articuloInsumo;

}
