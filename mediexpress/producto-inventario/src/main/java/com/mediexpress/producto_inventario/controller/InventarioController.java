package com.mediexpress.producto_inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.producto_inventario.model.Inventario;
import com.mediexpress.producto_inventario.service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Métodos del controlador para manejar las operaciones CRUD de Inventario
    // Listar todos los inventarios
    @GetMapping("/listar")
    public List<Inventario> listarInventario() {
        return inventarioService.obtenerTodos();
    }

    // Obtener un inventario por su ID
    @GetMapping("/{id}")
    public Inventario obtener(@PathVariable Long id) {
        return inventarioService.obtenerPorId(id);
    }


    // metodo para crear un nuevo inventario
    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.crear(inventario);
    }

    // metodo para actualizar un inventario existente
    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario inventario) {
        return inventarioService.actualizar(id, inventario);
    }

    // metodo para eliminar un inventario por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }
}
