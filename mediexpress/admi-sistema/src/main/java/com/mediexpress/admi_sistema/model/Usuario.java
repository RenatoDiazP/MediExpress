package com.mediexpress.admi_sistema.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "tabla de Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del usuario", example = "10")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema(description = "Nombre de usuario", example = "juan.perez")
    private String username;

    @Column(nullable = false)
    @Schema(description = "Contraseña cifrada del usuario", example = "$2a$10$...")
    private String password;

    @Schema(description = "Indica si el usuario está activo o no", example = "true")
    private boolean activo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    @Schema(description = "Lista de roles asignados al usuario")
    private List<Rol> roles;

}
