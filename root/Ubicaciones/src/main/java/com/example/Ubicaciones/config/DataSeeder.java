package com.example.Ubicaciones.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Ubicaciones.model.Comunas;
import com.example.Ubicaciones.model.Regiones;
import com.example.Ubicaciones.repository.ComunaRepository;
import com.example.Ubicaciones.repository.RegionRepository;

@Component
public class DataSeeder implements CommandLineRunner
{
    @Autowired
    public ComunaRepository comunaRepository;

    @Autowired
    public RegionRepository regionRepository;

    @Override
    public void run(String... args) throws Exception
    {
        preloadRegionMetropolitana();
    }

    private void preloadRegionMetropolitana()
    {
        if (regionRepository.count() == 0)
        {
            Regiones rm = new Regiones();
            rm.setNombreRegion("Región Metropolitana de Santiago");
            regionRepository.save(rm);

            List<String> comunas = List.of
            (
                "Colina","Lampa","Til Til","Pirque","Puente Alto","San José de Maipo",
                "Buin","Calera de Tango","Paine","San Bernardo","Alhué","Curacaví",
                "María Pinto","Melipilla","San Pedro","Cerrillos","Cerro Navia",
                "Conchalí","El Bosque","Estación Central","Huechuraba","Independencia",
                "La Cisterna","La Granja","La Florida","La Pintana","La Reina",
                "Las Condes","Lo Barnechea","Lo Espejo","Lo Prado","Macul","Maipú",
                "Ñuñoa","Pedro Aguirre Cerda","Peñalolén","Providencia","Pudahuel",
                "Quilicura","Quinta Normal","Recoleta","Renca","San Miguel","San Joaquín",
                "San Ramón","Santiago","Vitacura","El Monte","Isla de Maipo",
                "Padre Hurtado","Peñaflor","Talagante"
            );

            comunas.stream().forEach(nombre -> 
            {
                Comunas c = new Comunas();
                c.setNombreComuna(nombre);
                c.setRegion(rm);
                comunaRepository.save(c);
            });
        }
    }
}
