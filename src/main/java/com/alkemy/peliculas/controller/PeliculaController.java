package com.alkemy.peliculas.controller;

import com.alkemy.peliculas.dto.PeliculaDTO;
import com.alkemy.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO dto){
        PeliculaDTO dtoGuardado = peliculaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoGuardado);
    }
}
