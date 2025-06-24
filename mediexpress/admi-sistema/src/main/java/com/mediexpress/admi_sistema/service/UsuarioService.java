package com.mediexpress.admi_sistema.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.admi_sistema.model.Rol;
import com.mediexpress.admi_sistema.model.Usuario;
import com.mediexpress.admi_sistema.repository.RolRepository;
import com.mediexpress.admi_sistema.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario obtener(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario u = obtener(id);
        u.setUsername(datos.getUsername());
        u.setPassword(datos.getPassword());
        u.setActivo(datos.isActivo());
        u.setRoles(datos.getRoles());
        return usuarioRepository.save(u);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario asignarRoles(Long usuarioId, List<Long> rolIds) {
        Usuario usuario = obtener(usuarioId);
        List<Rol> roles = rolRepository.findAllById(rolIds);
        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

}
