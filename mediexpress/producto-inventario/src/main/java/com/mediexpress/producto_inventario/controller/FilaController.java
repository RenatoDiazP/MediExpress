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

import com.mediexpress.producto_inventario.model.Fila;
import com.mediexpress.producto_inventario.service.FilaService;

@RestController
@RequestMapping("/fila")
public class FilaController {
    @Autowired
    private FilaService filaService;

    @GetMapping
    public ResponseEntity<List<Fila>> listarFilas() {
        return ResponseEntity.ok(filaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fila> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Fila> crear(@RequestBody Fila fila) {
        return ResponseEntity.ok(filaService.crear(fila));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fila> actualizar(@PathVariable Long id, @RequestBody Fila actualizada) {
        return ResponseEntity.ok(filaService.actualizar(id, actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        filaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
