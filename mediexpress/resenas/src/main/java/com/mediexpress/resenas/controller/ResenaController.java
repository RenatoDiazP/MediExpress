package com.mediexpress.resenas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.resenas.model.Resena;
import com.mediexpress.resenas.service.ResenaService;

@RestController
@RequestMapping("/api/resena")
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Resena> getAll() {
        return resenaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Resena> getById(@PathVariable Long id) {
        return resenaService.findById(id);
    }

    @GetMapping("/producto/{idProd}")
    public List<Resena> getByProducto(@PathVariable Long idProd) {
        return resenaService.findByProductoId(idProd);
    }

    @PostMapping
    public Resena create(@RequestBody Resena resena) {
        return resenaService.save(resena);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resenaService.deleteById(id);
    }
}
