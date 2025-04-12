package com.example.MiApiRest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Categoria extends Base implements Serializable {
    @Column
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "id_categoria_padre")
    @JsonIgnore
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre")
    @Builder.Default
    private Set<Categoria> subcategorias = new HashSet<>();
}
