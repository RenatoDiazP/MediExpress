package com.mediexpress.admi_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.admi_sistema.model.Privilegio;

@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Long> {
    

}
