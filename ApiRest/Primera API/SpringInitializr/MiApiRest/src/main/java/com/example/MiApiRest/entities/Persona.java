package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "personas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_persona")
    protected String nombre;

    @Column(name = "apellido_perosna")
    protected String apellido;

    @Column (name = "telefono")
    protected String telefono;

    @Column (name = "email")
    protected String email;

    @Column (name = "fecha_nacimiento")
    protected LocalDate fechaNacimiento;

}
