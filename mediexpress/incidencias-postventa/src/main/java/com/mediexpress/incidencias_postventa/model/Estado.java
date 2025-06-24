package com.mediexpress.incidencias_postventa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "tabla de estado", description = "Representa el estado de una incidencia postventa")
public class Estado {
    @Id
    @Schema(name = "codigo del estado", description = "Identificador único del estado", example = "1")
    private Long idEstado;

    @Schema(description = "Nombre del estado", example = "Pendiente")
    private String nombreEstado;
}
