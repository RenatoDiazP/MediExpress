package com.example.Usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado
{
    @Id
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(nullable = false)
    private String nombreEstado;
}
