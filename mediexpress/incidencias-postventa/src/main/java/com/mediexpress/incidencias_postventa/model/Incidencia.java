package com.mediexpress.incidencias_postventa.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "incidencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Incidencia", description = "Representa una incidencia postventa relacionada con una venta")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "idIncidencia", description = "ID de la incidencia")
    private Long idIncidencia;

    private LocalDate fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_motivo")
    private Motivo motivo;
}
