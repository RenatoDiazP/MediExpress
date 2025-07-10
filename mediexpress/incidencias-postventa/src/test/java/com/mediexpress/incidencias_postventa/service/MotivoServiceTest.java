package com.mediexpress.incidencias_postventa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediexpress.incidencias_postventa.model.Motivo;

@SpringBootTest
public class MotivoServiceTest {

    @Autowired
    private MotivoService motivoService;

    @Test
    void testCrearMotivo() {
        Motivo motivo = new Motivo(null, "Producto vencido");
        Motivo guardado = motivoService.save(motivo);
        assertNotNull(guardado.getIdMotivo());
        assertEquals("Producto vencido", guardado.getDescripcion());
    }
}
