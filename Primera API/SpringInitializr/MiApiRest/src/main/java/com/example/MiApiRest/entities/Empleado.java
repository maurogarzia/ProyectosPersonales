package com.example.MiApiRest.entities;

import com.example.MiApiRest.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.NavigableMap;
import java.util.Set;

@Entity
@Table (name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Empleado extends Persona implements Serializable{

    @Column(name = "tipo_empleado")
    private Rol tipoEmpleado;

    @OneToOne
    @JoinColumn(name = "id_imagen_empleado")
    private ImagenEmpleado imagenEmpleado;


    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;




}
