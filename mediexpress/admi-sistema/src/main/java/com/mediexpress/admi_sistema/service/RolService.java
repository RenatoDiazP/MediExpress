package com.mediexpress.admi_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.admi_sistema.model.Privilegio;
import com.mediexpress.admi_sistema.model.Rol;
import com.mediexpress.admi_sistema.repository.PrivilegioRepository;
import com.mediexpress.admi_sistema.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private PrivilegioRepository privilegioRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Rol crear(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizar(Long id, Rol actualizado) {
        Rol existente = rolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        existente.setNombre(actualizado.getNombre());
        return rolRepository.save(existente);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    public Rol asignarPrivilegios(Long rolId, List<Long> privilegioIds) {
        Rol rol = rolRepository.findById(rolId)
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        List<Privilegio> privilegios = privilegioRepository.findAllById(privilegioIds);
        rol.setPrivilegios(privilegios);

        return rolRepository.save(rol);
    }
}
