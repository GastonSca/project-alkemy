package com.alkemy.peliculas.service.impl;

import com.alkemy.peliculas.dto.PersonajeDTO;
import com.alkemy.peliculas.entity.PersonajeEntity;
import com.alkemy.peliculas.mapper.PersonajeMapper;
import com.alkemy.peliculas.repository.PersonajeRepository;
import com.alkemy.peliculas.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {


    @Autowired
    PersonajeMapper personajeMapper;

    @Autowired
    PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);

        return personajeMapper.personajeEntity2DTO(entitySaved, false);
    }


    public PersonajeDTO update(PersonajeDTO dto, Long id) {
        Optional<PersonajeEntity> op = personajeRepository.findById(id);
        if (op.isPresent()){
            PersonajeEntity entity = op.get();
            entity.setNombre(dto.getNombre());
            entity.setImagen(dto.getImagen());
            entity.setEdad(dto.getEdad());
            entity.setPeso(dto.getPeso());
            entity.setHistoria(dto.getHistoria());
            PersonajeEntity entitySaved = personajeRepository.save(entity);
            return personajeMapper.personajeEntity2DTO(entitySaved, false);
        }

        return null;
    }


    public Void delete(PersonajeDTO dto) {
        return null;
    }
}
