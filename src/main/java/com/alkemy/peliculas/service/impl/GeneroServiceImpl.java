package com.alkemy.peliculas.service.impl;

import com.alkemy.peliculas.dto.GeneroDTO;
import com.alkemy.peliculas.entity.GeneroEntity;
import com.alkemy.peliculas.mapper.GeneroMapper;
import com.alkemy.peliculas.repository.GeneroRepository;
import com.alkemy.peliculas.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO dto){
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
        GeneroEntity entitySaved = generoRepository.save(entity);
        return generoMapper.generoEntity2DTO(entitySaved);
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();
        return generoMapper.generoEntityList2DTOList(entities);
    }
}
