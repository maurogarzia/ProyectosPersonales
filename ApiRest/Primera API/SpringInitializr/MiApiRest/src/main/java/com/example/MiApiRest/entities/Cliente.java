package com.example.MiApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona implements Serializable{

}
