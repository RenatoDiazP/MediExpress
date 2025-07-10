package com.example.Usuarios.model;

public record Notificacion (
    Long idNotificacion,
    String descripcion,
    String fechaEnvio,
    Long idUsuario
){}