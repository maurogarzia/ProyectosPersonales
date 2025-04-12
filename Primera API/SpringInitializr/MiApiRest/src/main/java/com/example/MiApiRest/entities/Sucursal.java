package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "sucursal")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Sucursal extends Base implements Serializable {
    @Column
    private String nombre;
    @Column
    private LocalTime horarioApertura;
    @Column
    private LocalTime  horarioCierre;
    @Column
    private Boolean casaMatriz;

    @OneToOne
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToMany
    @JoinTable(name = "sucursal_categoria", joinColumns = @JoinColumn(name = "id_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "id_categorias"))
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "sucursal_promocion", joinColumns = @JoinColumn(name = "fk_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "fk_promociones"))
    @Builder.Default
    private Set<Promocion>promociones = new HashSet<>();



}
