package com.mediexpress.producto_inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.producto_inventario.model.Estante;
import com.mediexpress.producto_inventario.service.EstanteService;

@RestController
@RequestMapping("/estante")
public class EstanteController {
    @Autowired
    private EstanteService estanteService;

    @GetMapping
    public ResponseEntity<List<Estante>> listarEstantes() {
        return ResponseEntity.ok(estanteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estante> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estanteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estante> crear(@RequestBody Estante estante) {
        return ResponseEntity.ok(estanteService.crear(estante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estante> actualizar(@PathVariable Long id, @RequestBody Estante actualizado) {
        return ResponseEntity.ok(estanteService.actualizar(id, actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estanteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
