package com.example.notificaciones.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notificaciones.model.Notificacion;
import com.example.notificaciones.repository.NotificacionRepository;

@Service
public class NotificacionService
{
    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion crearNotificacion(Notificacion notificacion)
    {
        if(notificacion.getFechaEnvio() == null || notificacion.getFechaEnvio().isEmpty())
        {
            notificacion.setFechaEnvio(LocalDateTime.now().toString()); // Se trabaja con LocalDateTime, ya que al momento de "enviar" la notificación, se actualiza a la fecha del momento
        }
        notificacion.setLeido(false);
        return notificacionRepository.save(notificacion);
    }

    public void marcarComoLeida(Long id)
    {
        Notificacion n = notificacionRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Notificación no encontrada"));
        n.setLeido(true);
        notificacionRepository.save(n);
    }
}