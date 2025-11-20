package com.raquielra.starwars;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StarWarsController {

    private final StarWarsService service;

    public StarWarsController(StarWarsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcomeMessage() {
        return "Bem-vindo à Star Wars API! Use /api/films/search?title=...";
    }

    @GetMapping("/api/films/search")
    public Object searchFilms(@RequestParam(required = true) String title) {
        return service.searchFilmsByTitle(title);
    }
}