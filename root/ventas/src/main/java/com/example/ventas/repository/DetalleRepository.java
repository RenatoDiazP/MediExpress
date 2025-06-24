package com.example.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventas.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long>
{
    List<Detalle> findByVentaId(Long ventaId);
}
