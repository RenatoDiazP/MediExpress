package com.example.Ubicaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "id_direccion")
    private Long id;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_comuna", nullable = false)
    private Comunas comuna;

    @Column(name = "id_usuario",nullable = false)
    private Long usuarioId;
}
