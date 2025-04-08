package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table (name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Empleado extends Persona implements Serializable{

    @Column (name = "tipo_empleado")
    private String tipoEmpleado;



}
