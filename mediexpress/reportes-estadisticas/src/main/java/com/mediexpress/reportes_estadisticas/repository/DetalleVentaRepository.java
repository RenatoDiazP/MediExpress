package com.mediexpress.reportes_estadisticas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mediexpress.reportes_estadisticas.model.DetalleVenta;

@Repository

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query("SELECT d.producto.nombre, SUM(d.cantidad) FROM DetalleVenta d GROUP BY d.producto.nombre ORDER BY SUM(d.cantidad) DESC")
    List<Object[]> obtenerProductosMasVendidos();
}
