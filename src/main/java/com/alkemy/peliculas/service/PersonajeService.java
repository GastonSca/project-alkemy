package com.alkemy.peliculas.service;

import com.alkemy.peliculas.dto.PersonajeDTO;
import org.springframework.stereotype.Service;


public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO dto);
    PersonajeDTO update(PersonajeDTO dto, Long id);
    Void delete(PersonajeDTO dto);

}
