package com.example.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;

@Service
public class VentaService
{
    @Autowired
    public VentaRepository ventaRepository;

    public List<Venta> findAll()
    {
        return ventaRepository.findAll();
    }

    public Optional<Venta> findById(Long id)
    {
        return ventaRepository.findById(id);
    }

    public Venta save(Venta venta)
    {
        return ventaRepository.save(venta);
    }

    public void delete(Long id)
    {
        ventaRepository.deleteById(id);
    }
}
