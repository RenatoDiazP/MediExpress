package com.mediexpress.incidencias_postventa.controller;

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

import com.mediexpress.incidencias_postventa.model.Estado;
import com.mediexpress.incidencias_postventa.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAll() {
        List<Estado> estados = estadoService.findAll();
        return estados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Long id) {
        try {
            Estado estado = estadoService.findById(id);
            return ResponseEntity.ok(estado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        Estado creado = estadoService.save(estado);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado estado) {
        try {
            estado.setIdEstado(id);
            Estado actualizado = estadoService.save(estado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            estadoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

