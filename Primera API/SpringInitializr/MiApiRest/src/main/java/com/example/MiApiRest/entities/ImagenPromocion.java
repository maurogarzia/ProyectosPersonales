package com.example.MiApiRest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "imagen_promocion")
@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class ImagenPromocion extends Imagen implements Serializable {

}
