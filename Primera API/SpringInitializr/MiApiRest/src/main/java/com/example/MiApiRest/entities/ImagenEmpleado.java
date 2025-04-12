package com.example.MiApiRest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "imagen_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public class ImagenEmpleado extends Imagen implements Serializable {
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
