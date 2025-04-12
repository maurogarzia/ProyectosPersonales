package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
public abstract class Usuario extends Base implements Serializable {

    @Column(name = "auth_Id")
    private String auth0Id;

    @Column(name = "nombre_usuario")
    private String username;

}
