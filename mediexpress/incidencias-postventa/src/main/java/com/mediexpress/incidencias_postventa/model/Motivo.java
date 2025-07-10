package com.mediexpress.incidencias_postventa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "motivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "tabla de motivo", description = "Representa un motivo asociado a una incidencia postventa")
public class Motivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "codigo del motivo", description = "Identificador único del motivo", example = "1")
    private Long idMotivo;


    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 3, max = 100, message = "La descripción debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    @Schema(description = "Descripción del motivo", example = "Producto defectuoso")
    private String descripcion;
}
