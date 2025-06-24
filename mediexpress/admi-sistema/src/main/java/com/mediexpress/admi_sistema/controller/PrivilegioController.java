package com.mediexpress.admi_sistema.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.mediexpress.admi_sistema.model.Privilegio;
import com.mediexpress.admi_sistema.service.PrivilegioService;

@RestController
@RequestMapping("/admin/roles")
public class PrivilegioController {
    @Autowired
    private PrivilegioService privilegioService;

    // Obtener todos los privilegios
    @GetMapping
    public ResponseEntity<List<Privilegio>> listarTodos() {
        List<Privilegio> privilegios = privilegioService.listar();
        if (privilegios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(privilegios);
    }

    // Obtener un privilegio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Privilegio> obtenerPorId(@PathVariable Long id) {
        try {
            Privilegio privilegio = privilegioService.obtener(id);
            return ResponseEntity.ok(privilegio);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo privilegio
    @PostMapping
    public ResponseEntity<Privilegio> crear(@RequestBody Privilegio privilegio) {
        Privilegio creado = privilegioService.crear(privilegio);
        return ResponseEntity.status(201).body(creado);
    }

    // Actualizar un privilegio existente
    @PutMapping("/{id}")
    public ResponseEntity<Privilegio> actualizar(@PathVariable Long id, @RequestBody Privilegio privilegioActualizado) {
        try {
            Privilegio actualizado = privilegioService.actualizar(id, privilegioActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un privilegio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            privilegioService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
