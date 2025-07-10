package com.example.notificaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificaciones.model.Notificacion;
import com.example.notificaciones.service.NotificacionService;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController
{
    @Autowired
    private NotificacionService service;

    @PostMapping
    public ResponseEntity<Notificacion> crear(@RequestBody Notificacion notificacion)
    {
        return ResponseEntity.ok(service.crearNotificacion(notificacion));
    }
    
    @PutMapping("/{id}/leida")
    public ResponseEntity<Void> marcarComoLeida(@PathVariable Long id)
    {
        service.marcarComoLeida(id);
        return ResponseEntity.noContent().build();
    }
}