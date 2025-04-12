package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "provincia")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provincia extends Base implements Serializable {
    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
}
