# 🚀 Star Wars API Backend (Spring Boot REST)

Este repositório contém o serviço RESTful principal, desenvolvido em Java com Spring Boot, responsável por consumir a API externa SWAPI (Star Wars API) e fornecer os dados para o Frontend.

## ✨ Visão Geral da Arquitetura

O projeto segue a arquitetura em camadas (Controller -> Service -> Data Source), focando em:

* **Comunicação Externa:** Uso de `RestTemplate` para requisições HTTP GET à SWAPI (API externa).
* **Controle REST:** Mapeamento de endpoints usando `@RestController` e tratamento de parâmetros de consulta (`@RequestParam`).
* **Mapeamento POJO:** Desserialização de JSON em objetos Java (`StarWarsFilm`).
* **Tolerância a Falhas:** Tratamento de exceções (CORS, 4xx, Erros de Conexão).

---

## 🛠️ Tecnologias Principais

* **Linguagem:** Java (JDK 21/25 LTS)
* **Framework:** Spring Boot (v3.x)
* **Build Tool:** Maven Daemon (`mvnd`)
* **Documentação:** SpringDoc/Swagger UI (para testes interativos)

---

## 🔗 Como Rodar o Backend

1.  **Pré-requisitos:** Java JDK 21+ e Maven (ou mvnd) instalados.
2.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/RaquielRA/star-wars-app.git]
    cd star-wars-app
    ```
3.  **Executar o Servidor:** Mantenha este terminal ativo para que o Frontend possa se conectar.
    ```bash
    mvnd spring-boot:run
    ```

### Teste Rápido da API

Com o servidor rodando, acesse estas URLs no seu navegador:

* **Documentação Interativa (Swagger):** `http://localhost:8080/swagger-ui.html`
* **Endpoint de Busca (JSON):** `http://localhost:8080/api/films/search?title=menace`

---

## 🌐 Conexão com o Frontend

Esta API é consumida pela interface de usuário (Frontend).

* **Repositório do Frontend (React):** **[star-wars-api-frontend](https://github.com/RaquielRA/star-wars-frontend.git)**