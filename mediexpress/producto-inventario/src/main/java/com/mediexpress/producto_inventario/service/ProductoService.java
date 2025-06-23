package com.mediexpress.producto_inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.producto_inventario.model.Producto;
import com.mediexpress.producto_inventario.repository.ProductoRepository;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    //listar todos los productos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

        // Obtener un producto por su ID
    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    // Crear un nuevo producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto actualizarProducto(Long id, Producto nuevoProducto) {
        Producto existente = obtenerProducto(id);
        existente.setNombre(nuevoProducto.getNombre());
        existente.setDescripcion(nuevoProducto.getDescripcion());
        existente.setCategoria(nuevoProducto.getCategoria());
        existente.setUnidad(nuevoProducto.getUnidad());
        return productoRepository.save(existente);
    }
    // Eliminar un producto por su ID
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
