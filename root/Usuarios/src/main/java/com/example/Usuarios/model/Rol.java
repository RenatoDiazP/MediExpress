package com.example.Usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol
{
    @Id
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;
}
