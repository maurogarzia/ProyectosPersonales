package com.example.MiApiRest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Entity
@Table(name = "articulo_insumo")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloInsumo extends Articulo implements Serializable {

    private Double precioCompra;


    private Integer stockActual;


    private Integer stockMaximo;


    private Boolean paraElaborar;
}
