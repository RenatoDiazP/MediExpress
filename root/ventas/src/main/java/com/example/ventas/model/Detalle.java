package com.example.ventas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
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
@Table(name = "detalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Tabla de Detalle")
public class Detalle
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle", nullable = false)
    @Schema(name = "Id del Detalle")
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    @Schema(name = "Id de la Venta asociada al Detalle")
    private Venta venta;

    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(name = "cantidad", nullable = false)
    private Long cantidad;

    @Column(name = "subtotal", nullable = false)
    private Long subtotal;
}
