package com.mediexpress.producto_inventario.model;

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
@Table(name = "fila")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Modelo de Fila")
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fila")
    @Schema(name = "Id de la Fila")
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_estante")
    private Estante estante;
}
