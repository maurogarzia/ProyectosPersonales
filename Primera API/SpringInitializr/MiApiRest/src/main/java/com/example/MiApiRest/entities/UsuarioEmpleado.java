package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "usuario_empleado")
@Setter
@Getter
@AllArgsConstructor
@SuperBuilder

public class UsuarioEmpleado extends Usuario{
    @OneToOne
    @JoinColumn(name = "empleado")
    private Empleado empleado;
}
