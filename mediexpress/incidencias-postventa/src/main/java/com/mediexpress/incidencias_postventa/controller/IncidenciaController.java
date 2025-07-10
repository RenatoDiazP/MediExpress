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

import com.mediexpress.incidencias_postventa.model.Incidencia;
import com.mediexpress.incidencias_postventa.service.IncidenciaService;

@RestController
@RequestMapping("api/incidencia")
public class IncidenciaController {
    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<List<Incidencia>> getAll() {
        List<Incidencia> incidencias = incidenciaService.findAll();
        return incidencias.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(incidencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(incidenciaService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Incidencia> create(@RequestBody Incidencia incidencia) {
        return ResponseEntity.status(201).body(incidenciaService.save(incidencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> update(@PathVariable Long id, @RequestBody Incidencia updated) {
        try {
            updated.setIdIncidencia(id);
            return ResponseEntity.ok(incidenciaService.save(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            incidenciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
