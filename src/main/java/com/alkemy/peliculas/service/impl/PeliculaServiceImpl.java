package com.alkemy.peliculas.service.impl;

import com.alkemy.peliculas.dto.PeliculaDTO;
import com.alkemy.peliculas.entity.PeliculaEntity;
import com.alkemy.peliculas.entity.PersonajeEntity;
import com.alkemy.peliculas.mapper.PeliculaMapper;
import com.alkemy.peliculas.repository.PeliculaRepository;
import com.alkemy.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    PeliculaMapper peliculaMapper;

    @Autowired
    PeliculaRepository peliculaRepository;

    public PeliculaDTO save(PeliculaDTO dto) {
        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity entitySaved = peliculaRepository.save(entity);
        Set<PersonajeEntity> entityList = new HashSet<>();
        dto.getPersonajes().forEach(ex -> {
            PersonajeEntity entity1 = new PersonajeEntity();
            entity1.setId(ex.getId());
            entityList.add(entity1);
        });
        entitySaved.setPersonajes(entityList);
        return peliculaMapper.peliculaEntity2DTO(entitySaved, false);
    }

    public PeliculaDTO update(PeliculaDTO dto) {
        return null;
    }
}
