package com.example.ventas.controller;

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

import com.example.ventas.model.Venta;
import com.example.ventas.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController
{
    @Autowired
    public VentaService ventaService;

    @GetMapping
    public List<Venta> getAll() 
    {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Long id)
    {
        return ventaService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venta create(@RequestBody Venta venta)
    {
        return ventaService.save(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Long id, @RequestBody Venta venta)
    {
        if (!ventaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        venta.setIdVenta(id);
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        if (!ventaService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        ventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
