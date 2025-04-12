package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Empresa extends Base implements Serializable {
    @Column
    private String nombre;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column
    private Integer cuil;


}
