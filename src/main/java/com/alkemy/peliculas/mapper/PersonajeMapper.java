package com.alkemy.peliculas.mapper;

import com.alkemy.peliculas.dto.PeliculaDTO;
import com.alkemy.peliculas.dto.PersonajeDTO;
import com.alkemy.peliculas.entity.PersonajeEntity;
import com.alkemy.peliculas.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class PersonajeMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity entity = new PersonajeEntity();
        entity.setNombre(dto.getNombre());
        entity.setImagen(dto.getImagen());
        entity.setEdad(dto.getEdad());
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        return entity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, boolean loadPeliculas){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        if (loadPeliculas){
            List<PeliculaDTO> peliculasDTO = peliculaMapper.peliculaEntityList2DTOList(entity.getPeliculas(), false);
            dto.setPeliculas(peliculasDTO);
        }
        return dto;
    }

    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<PersonajeEntity> entities, boolean loadPelicula){
        List<PersonajeDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity: entities) {
            dtos.add(personajeEntity2DTO(entity, loadPelicula));
        }
        return dtos;
    }

    public Set<PersonajeEntity> personajeDTOSet2Entity(List<PersonajeDTO> dtos){
        Set<PersonajeEntity> entities = new HashSet<>();
        for (PersonajeDTO dto: dtos) {
            entities.add(personajeDTO2Entity(dto));
        }
        return entities;
    }



}
