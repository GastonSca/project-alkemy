package com.alkemy.peliculas.controller;

import com.alkemy.peliculas.dto.PersonajeDTO;
import com.alkemy.peliculas.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO dto){

        PersonajeDTO dtoGuardado = personajeService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@RequestBody PersonajeDTO dto, @PathVariable Long id){

        PersonajeDTO dtoActualizado = personajeService.update(dto, id);

        return ResponseEntity.status(HttpStatus.OK).body(dtoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonajeDTO> delete(@PathVariable Long id){
        return null;
    }

}
