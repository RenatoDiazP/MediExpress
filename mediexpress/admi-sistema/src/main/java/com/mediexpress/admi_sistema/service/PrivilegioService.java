package com.mediexpress.admi_sistema.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.admi_sistema.model.Privilegio;
import com.mediexpress.admi_sistema.repository.PrivilegioRepository;

@Service
public class PrivilegioService {
    @Autowired
    private PrivilegioRepository privilegioRepository;

    public List<Privilegio> listar() {
        return privilegioRepository.findAll();
    }

    public Privilegio obtener(Long id) {
        return privilegioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Privilegio no encontrado"));
    }

    public Privilegio crear(Privilegio p) {
        return privilegioRepository.save(p);
    }

    public Privilegio actualizar(Long id, Privilegio datos) {
        Privilegio p = obtener(id);
        p.setNombre(datos.getNombre());
        p.setModulo(datos.getModulo());
        return privilegioRepository.save(p);
    }

    public void eliminar(Long id) {
        privilegioRepository.deleteById(id);
    }

}
