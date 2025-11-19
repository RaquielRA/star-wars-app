package com.raquielra.starwars;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException; // Importa para tratar erros comuns de API

@Service
public class StarWarsService {

    private final RestTemplate restTemplate;
    private static final String API_BASE_URL = "https://swapi.dev/api/films/{id}/";

    public StarWarsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StarWarsFilm fetchFilmById(int id) {
        System.out.println("🚀 Buscando filme de Star Wars ID: " + id);
        
        try {
            StarWarsFilm film = restTemplate.getForObject(
                API_BASE_URL, 
                StarWarsFilm.class, 
                id
            );
            
            System.out.println("✅ Filme recebido e convertido.");
            return film;
            
        } catch (HttpClientErrorException e) {
            // Trata erros comuns do lado do cliente (códigos 4xx, como 404 Not Found)
            System.err.println("❌ Erro ao consumir a API (Cliente/4xx). Status: " + e.getStatusCode());
            System.err.println("Corpo da Resposta de Erro: " + e.getResponseBodyAsString());
            return null;
        } catch (Exception e) {
            // Trata erros de conexão, servidor (códigos 5xx) ou outros erros inesperados
            System.err.println("❌ Erro inesperado ao consumir a SWAPI: " + e.getMessage());
            // e.printStackTrace(); // Útil para debug
            return null;
        }
    }
}