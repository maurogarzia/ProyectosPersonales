package com.example.MiApiRest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "unidad_medida")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UnidadMedida extends Base implements Serializable {

    @Column
    private String denominacion;

}
