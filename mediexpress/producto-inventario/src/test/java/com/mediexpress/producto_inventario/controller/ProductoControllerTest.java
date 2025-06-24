package com.mediexpress.producto_inventario.controller;

import com.mediexpress.producto_inventario.model.Producto;
import com.mediexpress.producto_inventario.service.ProductoService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Test
    void listarTodos_retornar200YLista() throws Exception {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Ejemplo");

        Mockito.when(productoService.listarProductos()).thenReturn(List.of(producto));

        mockMvc.perform(get("/producto"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].nombre").value("Ejemplo"));
    }

    @Test
    void listarTodos_sinResultados_retornar204() throws Exception {
        Mockito.when(productoService.listarProductos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/producto"))
            .andExpect(status().isNoContent());
    }
}



