package com.mediexpress.incidencias_postventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.incidencias_postventa.model.Incidencia;



@Repository
public interface IncidenciaRepository extends JpaRepository <Incidencia, Long> {
    

}
