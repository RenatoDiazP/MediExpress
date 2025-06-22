package com.mediexpress.producto_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediexpress.producto_inventario.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
