package com.example.ventas.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Tabla de Ventas")
public class Venta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta", nullable = false)
    @Schema(name = "Id de la Venta")
    private Long id;

    @Column(name = "fecha_venta", nullable = false)
    private String fechaVenta;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "total", nullable = false)
    private Long total;

    @Column(name = "id_estado", nullable = false)
    private Long idEstado;

    @Column(name = "idDireccion", nullable = false)
    private Long idDireccion;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detalle> detalles = new ArrayList<>();
}
