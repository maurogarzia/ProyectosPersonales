package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Entity
@Table(name = "imagenes")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
public abstract class Imagen extends Base implements Serializable {

    @Column
    private String denominacion;

}
