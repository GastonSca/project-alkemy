package com.alkemy.peliculas.mapper;

import com.alkemy.peliculas.dto.PeliculaDTO;
import com.alkemy.peliculas.dto.PersonajeDTO;
import com.alkemy.peliculas.entity.PeliculaEntity;
import com.alkemy.peliculas.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Set;

@Component
public class PeliculaMapper {

    @Autowired
    PersonajeMapper personajeMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity entity = new PeliculaEntity();
        entity.setImagen(dto.getImagen());
        entity.setTitulo(dto.getTitulo());
        //entity.setFechaCreacion(string2LocalDate(dto.getFechaCreacion()));
        entity.setCalificacion(dto.getCalificacion());
        if (dto.getGeneroId() != null){
            entity.setGeneroId(dto.getGeneroId());
        } else {
            entity.setGeneroId(5L);
        }
        Set<PersonajeEntity> personajes = personajeMapper.personajeDTOSet2Entity(dto.getPersonajes());
        entity.setPersonajes(personajes);

        return entity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean loadPersonaje){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setCalificacion(entity.getCalificacion());
        dto.setGeneroId(entity.getGeneroId());
        if (loadPersonaje) {
            List<PersonajeDTO> personajeDTOS = personajeMapper.personajeEntitySet2DTOList(entity.getPersonajes(), false);
            dto.setPersonajes(personajeDTOS);
        }
        return dto;
    }

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> entities, boolean loadPersonaje){
        List<PeliculaDTO> dtos = new ArrayList<>();

        for (PeliculaEntity entity: entities) {
            dtos.add(peliculaEntity2DTO(entity, loadPersonaje));
        }
        return dtos;
    }
    /*
    private LocalDate string2LocalDate(String stringDate){
        return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
         */


}
