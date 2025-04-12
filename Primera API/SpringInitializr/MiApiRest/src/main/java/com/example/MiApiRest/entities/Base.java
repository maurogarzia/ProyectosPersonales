package com.example.MiApiRest.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public abstract class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
}
