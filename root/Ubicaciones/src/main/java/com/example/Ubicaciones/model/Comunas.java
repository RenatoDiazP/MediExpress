package com.example.Ubicaciones.model;

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
    private Long idComuna;

    @Column(nullable = false)
    private String nombreComuna;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Regiones region;
}
