package com.example.MiApiRest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;
import java.io.Serializable;
@Entity
@Table(name = "articulo_manufacturado")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class ArticuloManufacturado extends Articulo implements Serializable {
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "minutos_estimados")
    private Integer tiempoEstimadoMinutos;

    @Column(name = "preparacion")
    private String preparacion;



}
