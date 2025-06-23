package com.mediexpress.reportes_estadisticas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.reportes_estadisticas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
    List<Venta> findByFechaBetween(LocalDate desde, LocalDate hasta);
    List<Venta> findByUsuarioId(Long idUsuario);

}
