package com.example.MiApiRest.entities;

import com.example.MiApiRest.entities.enums.TipoPromocion;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promocion")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion extends Base implements Serializable {
    @Column
    private String denominacion;
    @Column(name = "fecha_desde")
    private LocalDate fechaDesde;
    @Column(name = "fecha_hasta")
    private LocalDate fechaHasta;
    @Column(name = "hora_desde")
    private LocalTime horaDesde;
    @Column(name = "hora_hasta")
    private LocalTime horaHasta;
    @Column(name = "decuento")
    private String descripcionDescuento;
    @Column(name = "precio_promocional")
    private Double precioPromocional;
    @Column(name = "tipo_promocion")
    private TipoPromocion tipoPromocion;

    @OneToMany
    @Builder.Default
    @JoinColumn(name = "id_imagen_promocion")
    private Set<Imagen> imagenPromocion = new HashSet<>();




}
