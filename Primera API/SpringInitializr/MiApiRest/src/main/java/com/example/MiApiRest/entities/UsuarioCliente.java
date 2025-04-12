package com.example.MiApiRest.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Entity
@Table(name = "usuario_cliente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UsuarioCliente extends Usuario implements Serializable {
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
