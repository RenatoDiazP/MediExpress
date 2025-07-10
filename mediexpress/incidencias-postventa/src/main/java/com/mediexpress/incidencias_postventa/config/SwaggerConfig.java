package com.mediexpress.incidencias_postventa.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Incidencias PostVenta",
        version = "1.0",
        description = "Documentación de la API de gestión de incidencias postventa"
    )
)
public class SwaggerConfig {


}
