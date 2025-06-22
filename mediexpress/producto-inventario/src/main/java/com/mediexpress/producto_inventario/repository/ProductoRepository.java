package com.mediexpress.producto_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediexpress.producto_inventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
