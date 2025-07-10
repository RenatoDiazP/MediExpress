package com.example.notificaciones.model;

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
@Table(name = "notificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion",nullable = false)
    @Schema(name = "Id de la notificación")
    private Long id;

    @Column(name= "descripcion",nullable = false)
    @Schema(name = "Descripción e informacion de la notificación")
    private String descripcion;

    @Column(name = "fecha_envio", nullable = false)
    @Schema(name= "Fecha de envio de la notificación")
    private String fechaEnvio;

    @Column(name = "leido")
    @Schema(name = "Bool de leido")
    private boolean leido;

    @Column(name = "id_usuario", nullable = false)
    @Schema(name = "Id del usuario al que se le mando la notificación")
    private Long idUsuario;
}
