package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "promocion_detalle")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromocionDetalle extends Base implements Serializable {
    @Column
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;

    @ManyToOne
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;
}
