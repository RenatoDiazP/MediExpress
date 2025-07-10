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
@Table(name = "comunas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comunas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna", nullable = false)
    @Schema(name = "Id de la Comuna")
    private Long id;

    @Column(name = "nombre_comuna", nullable = false)
    @Schema(name = "Nombre de la Comuna")
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    @Schema(name = "Region asociada a la Comuna")
    private Regiones region;
}
