package com.example.Ubicaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "id_region")
    private Long idRegion;

    @Column(nullable = false)
    private String nombreRegion;
}