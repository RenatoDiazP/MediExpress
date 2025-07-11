package com.example.Usuarios.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Usuarios.model.Notificacion;
import com.example.Usuarios.model.Usuario;
import com.example.Usuarios.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    @Operation(summary = "Permite crear usuarios nuevos")
    @ApiResponses(value=
    {
        @ApiResponse(responseCode = "201", description = "Se ha creado un usuario", content=@Content(schema=@Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "400", description = "No se pudo crear un usuario, revise los datos")
    })
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario)
    {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping
    @Operation(summary = "Permite obtener una lista de los usuarios")
    @ApiResponses(value=
    {
        @ApiResponse(responseCode = "200", description = "Lista de los usuarios obtenida correctamente", content=@Content(schema=@Schema(implementation = Usuario.class)))
    })
    public ResponseEntity<List<Usuario>> listarUsuarios()
    {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Permite buscar usuarios por el ID")
    @ApiResponses(value = 
    {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado", content = @Content(schema=@Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id)
    {
        return usuarioService.obtenerPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());   
    }

    @GetMapping("/{id}/notificaciones")
    public ResponseEntity<List<Notificacion>> obtenerNotificaciones(@PathVariable Long id)
    {
        String url = "http://localhost:8082/notificaciones/usuario/" + id;

        try 
        {
            ResponseEntity<Notificacion[]> response = restTemplate.getForEntity(url, Notificacion[].class);

            if (response.getStatusCode().is2xxSuccessful()) {
                List<Notificacion> notificaciones = Arrays.asList(response.getBody());
                return ResponseEntity.ok(notificaciones);
            } else {
                return ResponseEntity.status(response.getStatusCode()).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina a un usuario, buscandolo por el Id")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Usuario eliminado con exito"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id)
    {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    @Operation(summary = "Permite iniciar sesión con correo y clave")
    @ApiResponses(value = 
    {
        @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso"),
        @ApiResponse(responseCode = "401", description = "Credenciales inválidas")
    })
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData)
    {
        try
        {
            String correo = loginData.get("correo");
            String clave = loginData.get("clave");
            String mensaje = usuarioService.login(correo, clave);

            return ResponseEntity.ok(mensaje);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}