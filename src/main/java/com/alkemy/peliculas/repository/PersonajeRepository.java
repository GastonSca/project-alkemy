package com.alkemy.peliculas.repository;

import com.alkemy.peliculas.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {

}
