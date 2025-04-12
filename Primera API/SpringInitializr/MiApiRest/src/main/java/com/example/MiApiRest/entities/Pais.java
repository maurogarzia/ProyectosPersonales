package com.example.MiApiRest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "pais")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pais extends Base implements Serializable {

    @Column
    private String nombre;
}
