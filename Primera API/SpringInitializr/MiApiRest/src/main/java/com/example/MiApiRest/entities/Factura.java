package com.example.MiApiRest.entities;

import com.example.MiApiRest.entities.enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends Base implements Serializable {

    private LocalDate fachaFacturacion;

    private Integer mpPaymentId;

    private Integer mpMerchantOrderId;

    private String mpPreferenceId;

    private String mpPaymentType;

    private FormaPago formaPago;

    private Double totalVenta;




}
