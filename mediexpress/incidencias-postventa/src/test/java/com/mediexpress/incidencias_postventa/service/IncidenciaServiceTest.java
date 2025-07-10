package com.mediexpress.incidencias_postventa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediexpress.incidencias_postventa.model.Estado;
import com.mediexpress.incidencias_postventa.model.Incidencia;
import com.mediexpress.incidencias_postventa.model.Motivo;

@SpringBootTest
public class IncidenciaServiceTest {
    @Autowired
    private IncidenciaService incidenciaService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MotivoService motivoService;

    @Test
    void testCrearIncidencia() {
        Estado estado = estadoService.save(new Estado(null, "Pendiente"));
        Motivo motivo = motivoService.save(new Motivo(null, "Producto roto"));

        Incidencia incidencia = new Incidencia();
        incidencia.setComentario("Producto roto");
        incidencia.setFechaInicio(LocalDate.now());
        incidencia.setEstado(estado);
        incidencia.setMotivo(motivo);

        Incidencia guardada = incidenciaService.save(incidencia);
        assertNotNull(guardada.getIdIncidencia());
        assertEquals("Producto roto", guardada.getComentario());
    }

}
