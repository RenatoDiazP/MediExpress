package com.mediexpress.admi_sistema.controller;

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

import com.mediexpress.admi_sistema.model.Modulo;
import com.mediexpress.admi_sistema.service.ModuloService;

@RestController
@RequestMapping("/admin/modulos")
public class ModuloController {
    @Autowired
    private ModuloService service;

    @GetMapping
    public ResponseEntity<List<Modulo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Modulo> crear(@RequestBody Modulo modulo) {
        return ResponseEntity.status(201).body(service.crear(modulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> actualizar(@PathVariable Long id, @RequestBody Modulo modulo) {
        return ResponseEntity.ok(service.actualizar(id, modulo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
