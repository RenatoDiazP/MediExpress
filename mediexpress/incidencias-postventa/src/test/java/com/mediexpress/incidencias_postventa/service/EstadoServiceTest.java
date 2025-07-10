package com.mediexpress.incidencias_postventa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediexpress.incidencias_postventa.model.Estado;

@SpringBootTest
public class EstadoServiceTest {
    @Autowired
    private EstadoService estadoService;

    @Test
    void testCrearEstado() {
        Estado estado = new Estado(null, "Procesando");
        Estado guardado = estadoService.save(estado);
        assertNotNull(guardado.getIdEstado());
        assertEquals("Procesando", guardado.getNombreEstado());
    }

}
