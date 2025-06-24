package com.example.Ubicaciones.model;

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
@Table(name = "direccion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion", nullable = false)
    @Schema(name = "Id de la Dirección")
    private Long id;

    @Column(name = "direccion", nullable = false)
    @Schema(name = "Direccion completa")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_comuna", nullable = false)
    @Schema(name = "Comuna asociada a la direccion")
    private Comunas comuna;

    @Column(name = "id_usuario",nullable = false)
    @Schema(name = "Id del usuario asociado a la direccion")
    private Long usuarioId;
}
