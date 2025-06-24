package com.mediexpress.admi_sistema.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "privilegio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "tabla de Privilegio")
public class Privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del privilegio", example = "GESTION_USUARIOS")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    @Schema(description = "Módulo al que pertenece el privilegio")
    private Modulo modulo;
}


