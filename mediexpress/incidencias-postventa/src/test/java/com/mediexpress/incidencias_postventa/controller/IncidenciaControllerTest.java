package com.mediexpress.incidencias_postventa.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mediexpress.incidencias_postventa.model.Incidencia;
import com.mediexpress.incidencias_postventa.service.IncidenciaService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(IncidenciaController.class)
public class IncidenciaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IncidenciaService incidenciaService;

    @Test
    void testObtenerPorId() throws Exception {
        Incidencia incidencia = new Incidencia();
        incidencia.setIdIncidencia(1L);
        incidencia.setComentario("Error de entrega");

        Mockito.when(incidenciaService.findById(1L)).thenReturn(incidencia);

        mockMvc.perform(get("/api/incidencia/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.comentario").value("Error de entrega"));
    }

}
