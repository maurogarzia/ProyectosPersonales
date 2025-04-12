package com.example.MiApiRest.entities;
import com.example.MiApiRest.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Cliente extends Persona implements Serializable{
    @Column(name = "rol_cliente")
    private Rol rolCliente;

    @OneToOne
    @JoinColumn(name = "id_imagen_cliente")
    private ImagenCliente imagenCliente;


    @ManyToOne
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;


}
