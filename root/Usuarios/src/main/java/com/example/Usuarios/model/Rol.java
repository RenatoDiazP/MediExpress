package com.example.Usuarios.model;

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
@Table(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    @Schema(name = "Id del Rol")
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false)
    @Schema(name = "Nombre del Rol")
    private String nombreRol;
}
