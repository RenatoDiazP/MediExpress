package com.mediexpress.producto_inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.producto_inventario.model.Inventario;
import com.mediexpress.producto_inventario.repository.InventarioRepository;


@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> obtenerTodos() {
        return inventarioRepository.findAll();
    }

    public Inventario obtenerPorId(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    public Inventario crear(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario actualizar(Long id, Inventario actualizado) {
        Inventario inv = obtenerPorId(id);
        inv.setProducto(actualizado.getProducto());
        inv.setStock(actualizado.getStock());
        inv.setPrecio(actualizado.getPrecio());
        inv.setFechaExp(actualizado.getFechaExp());
        return inventarioRepository.save(inv);
    }

    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }

    public List<Inventario> buscarPorProducto(Long productoId) {
        return inventarioRepository.findByProductoId(productoId);
    }
}
