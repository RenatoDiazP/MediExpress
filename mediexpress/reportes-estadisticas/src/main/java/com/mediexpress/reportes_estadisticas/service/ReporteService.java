package com.mediexpress.reportes_estadisticas.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.reportes_estadisticas.model.Venta;
import com.mediexpress.reportes_estadisticas.repository.DetalleVentaRepository;
import com.mediexpress.reportes_estadisticas.repository.VentaRepository;

@Service
public class ReporteService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<Object[]> productosMasVendidos() {
        return detalleVentaRepository.obtenerProductosMasVendidos();
    }

    public Double ingresosEntreFechas(LocalDate desde, LocalDate hasta) {
        List<Venta> ventas = ventaRepository.findByFechaBetween(desde, hasta);
        return ventas.stream().mapToDouble(Venta::getTotal).sum();
    }

    public Map<String, Long> usuariosFrecuentes() {
        List<Venta> ventas = ventaRepository.findAll();
        Map<String, Long> conteo = new HashMap<>();
        for (Venta v : ventas) {
            conteo.put(v.getUsuario().getNombre(), conteo.getOrDefault(v.getUsuario().getNombre(), 0L) + 1);
        }
        return conteo;
    }
}
