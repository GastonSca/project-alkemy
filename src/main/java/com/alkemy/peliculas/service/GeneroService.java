package com.alkemy.peliculas.service;

import com.alkemy.peliculas.dto.GeneroDTO;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    public GeneroDTO save(GeneroDTO dto){
        //TODO: guardar

        System.out.println("GUARDAR GENERO");
        return dto;
    }
}
