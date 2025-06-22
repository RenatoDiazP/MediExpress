package com.mediexpress.producto_inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.producto_inventario.model.Categoria;
import com.mediexpress.producto_inventario.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Métodos del servicio para manejar operaciones CRUD de Categoría
    // Listar todas las categorías
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    // Crear una nueva categoría
    public Categoria crear(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría 
    public Categoria actualizar(Long id, Categoria categoriaActualizada) {
        Categoria categoria = obtenerPorId(id);
        categoria.setNombre(categoriaActualizada.getNombre());
        return categoriaRepository.save(categoria);
    }

    // Eliminar una categoría por su ID
    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada para eliminar");
        }
        categoriaRepository.deleteById(id);
    }
}

