package com.mediexpress.reportes_estadisticas.model;

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
@Table(name = "detalle_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Modelo de Detalle de Venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del detalle de venta", example = "101")
    private Long id;

    @Schema(description = "Cantidad de unidades del producto vendidos", example = "3")
    private Integer cantidad;

    @Schema(description = "Subtotal calculado para esta línea de venta", example = "4500.00")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @Schema(description = "Producto asociado a este detalle de venta")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @Schema(description = "Venta asociada a este detalle")
    private Venta venta;

}
