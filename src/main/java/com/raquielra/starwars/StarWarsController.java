package com.raquielra.starwars;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private final StarWarsService service;

    public StarWarsController(StarWarsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcomeMessage() {
        return "Bem-vindo à Star Wars API! Use /api/filmes/search?title=...";
    }

    @GetMapping("/api/filme/search")
    public Object searchFilms(@RequestParam(required = true) String title) {
        return service.searchFilmsByTitle(title);
    }
}