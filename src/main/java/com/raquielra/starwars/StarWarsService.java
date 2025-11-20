package com.raquielra.starwars;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class StarWarsService {

    private final RestTemplate restTemplate;
    private static final String API_BASE_URL = "https://swapi.dev/api/films/?search={title}";

    public StarWarsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object searchFilmsByTitle(String title) {
        System.out.println("🚀 Buscando filme de Star Wars com o termo: " + title);
        
        try {
            Object response = restTemplate.getForObject(
                API_BASE_URL, 
                Object.class, 
                title
            );
            
            System.out.println("✅ Lista de filmes recebida.");
            return response;
            
        } catch (HttpClientErrorException e) {
            System.err.println("❌ Erro ao consumir a API (Cliente/4xx). Status: " + e.getStatusCode());
            System.err.println("Corpo da Resposta de Erro: " + e.getResponseBodyAsString());
            return null;
        } catch (ResourceAccessException e) {
            System.err.println("❌ Erro de Conexão ou Rede: " + e.getMessage());
            return null;
        }
    }
}