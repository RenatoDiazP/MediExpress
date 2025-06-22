package com.mediexpress.producto_inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediexpress.producto_inventario.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    List<Inventario> findByProductoId(Long productoId);

}
