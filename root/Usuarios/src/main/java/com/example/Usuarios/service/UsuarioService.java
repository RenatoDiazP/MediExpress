package com.example.Usuarios.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Usuarios.model.Usuario;
import com.example.Usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encrypt; //Para encriptar

    public Usuario guardarUsuario(Usuario usuario)
    {
        if(usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent())
        {
            throw new IllegalArgumentException("Este correo ya se encuentra registrado."); //Verificacion por correo → Si el correo existe dentro de la base de datos, no se crea el usuario
        }
        String claveEncriptada = encrypt.encode(usuario.getClave());
        usuario.setClave(claveEncriptada);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios()
    {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long Id)
    {
        return usuarioRepository.findById(Id);
    }

    public void eliminarUsuario(long Id)
    {
        usuarioRepository.deleteById(Id);
    }

    public String login(String correo, String clave)
    {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if(usuarioOpt.isEmpty())
        {
            throw new IllegalArgumentException("Correo Incorrecto");
        }

        Usuario user = usuarioOpt.get();

        if(!encrypt.matches(clave, user.getClave()))
        {
            throw new IllegalArgumentException("Contraseña Incorrecta");
        }

        return "Inicio de sesión exitoso";
    }
}