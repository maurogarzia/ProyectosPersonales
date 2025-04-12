package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "localidad")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localidad extends Base implements Serializable {
    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
}
