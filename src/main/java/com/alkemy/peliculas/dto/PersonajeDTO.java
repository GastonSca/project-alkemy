package com.alkemy.peliculas.dto;

import com.alkemy.peliculas.entity.PeliculaEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//Anotación para que el DTO ignore los nulos.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonajeDTO {

    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    private List<PeliculaDTO> peliculas;
}
