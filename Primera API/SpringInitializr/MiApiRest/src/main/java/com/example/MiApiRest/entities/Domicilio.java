package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Domicilio extends Base implements Serializable {
    @Column
    private String calle;
    @Column
    private Integer numero;
    @Column
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

}
