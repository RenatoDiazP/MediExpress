package com.mediexpress.incidencias_postventa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "tabla de venta")
public class Venta {
    @Id
    @Schema(name= "codigo de la venta", description = "Identificador único de la venta", example = "12345")
    private Long idVenta;
}
