package com.example.Ubicaciones.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Regiones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regiones
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region", nullable = false)
    @Schema(name = "Id de la Region")
    private Long idRegion;

    @Column(nullable = false)
    @Schema(name = "Nombre de la Region")
    private String nombreRegion;
}