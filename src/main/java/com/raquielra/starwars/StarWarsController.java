package com.raquielra.starwars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private final StarWarsService service;

    public StarWarsController(StarWarsService service) {
        this.service = service;
    }

    @GetMapping("/api/filme/{id}")
    public StarWarsFilm getFilmById(@PathVariable int id) {
        return service.fetchFilmById(id);
    }
}