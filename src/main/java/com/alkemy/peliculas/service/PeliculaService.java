package com.alkemy.peliculas.service;

import com.alkemy.peliculas.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

public interface PeliculaService {

    PeliculaDTO save(PeliculaDTO dto);
    PeliculaDTO update(PeliculaDTO dto);
}
