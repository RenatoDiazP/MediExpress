package com.mediexpress.producto_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.producto_inventario.model.Estante;

@Repository
public interface EstanteRepository extends JpaRepository<Estante, Long> {


}
