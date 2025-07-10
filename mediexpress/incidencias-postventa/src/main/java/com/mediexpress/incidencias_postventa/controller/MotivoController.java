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

import com.mediexpress.incidencias_postventa.model.Motivo;
import com.mediexpress.incidencias_postventa.service.MotivoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/motivo")
public class MotivoController {
    @Autowired
    private MotivoService motivoService;

    @GetMapping
    public ResponseEntity<List<Motivo>> getAll() {
        List<Motivo> motivos = motivoService.findAll();
        return motivos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(motivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motivo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(motivoService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Motivo> create(@Valid @RequestBody Motivo motivo) {
        return ResponseEntity.status(201).body(motivoService.save(motivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motivo> update(@PathVariable Long id, @Valid @RequestBody Motivo motivo) {
        try {
            motivo.setIdMotivo(id);
            return ResponseEntity.ok(motivoService.save(motivo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            motivoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

