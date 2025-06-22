package com.example.Usuarios.model;

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
@Table(name="Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario
{
    @Id
    @Column(name = "id_usuario") //PK usuario
    private Long idUsuario;

    @Column(nullable=false)
    private String correo;

    @Column(nullable = false)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) //Fk rol
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false) //Fk estado
    private Estado estado;
}