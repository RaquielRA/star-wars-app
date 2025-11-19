package com.raquielra.starwars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
	}
    
    @Bean
    public CommandLineRunner run(StarWarsService movieService) {
        return args -> {
            int filmId = 4; 
            StarWarsFilm film = movieService.fetchFilmById(filmId);

            if (film != null) {
                System.out.println("\n--- FILME STAR WARS ENCONTRADO ---");
                System.out.println("Título: " + film.getTitle());
                System.out.println("Episódio: " + film.getEpisodeId());
                System.out.println("Lançamento: " + film.getReleaseDate());
                System.out.println("Total de Personagens no Filme: " + film.getCharacters().size());
                System.out.println("------------------------------------");
            } else {
                System.out.println("\n--- Falha na busca ou API fora do ar ---");
            }
        };
    }
}