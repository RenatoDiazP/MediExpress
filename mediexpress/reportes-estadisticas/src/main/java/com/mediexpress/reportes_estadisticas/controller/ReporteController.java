package com.mediexpress.reportes_estadisticas.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.reportes_estadisticas.service.ReporteService;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    // Productos más vendidos
    @GetMapping("/productos-mas-vendidos")
    public List<Object[]> obtenerProductosMasVendidos() {
        return reporteService.productosMasVendidos();
    }

    // Ingresos entre fechas
    @GetMapping("/ingresos")
    public Double ingresosEntreFechas(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return reporteService.ingresosEntreFechas(desde, hasta);
    }

    // Usuarios frecuentes
    @GetMapping("/usuarios-frecuentes")
    public Map<String, Long> obtenerUsuariosFrecuentes() {
        return reporteService.usuariosFrecuentes();
    }
}

