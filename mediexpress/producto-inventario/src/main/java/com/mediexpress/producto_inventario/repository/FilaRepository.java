package com.mediexpress.producto_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.producto_inventario.model.Fila;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {
    

}
