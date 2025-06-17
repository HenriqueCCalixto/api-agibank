# Projeto Seguro API & Cliente API

Este repositório contém duas APIs independentes — **Seguro API** e **Cliente API** — que se comunicam entre si, cada uma rodando em seu container Docker com banco PostgreSQL separado.

O projeto foi estruturado com foco em **Clean Architecture**, **SOLID** e **mapeamento claro entre DTOs e entidades de domínio**.

---

## Tecnologias e Ferramentas

- Java 17+ (compatível com JDK 17)
- Spring Boot 3.x
- PostgreSQL
- Docker + Docker Compose
- MapStruct para mapeamento DTO ↔ Entidade
- Resilience4j para Circuit Breaker e fallback em chamadas HTTP

---

## Como rodar o ambiente

1. Clone o repositório:

```bash
git clone https://github.com/HenriqueCCalixto/api-agibank.git
cd api-agibank
```

2. Suba tudo com Docker Compose:

```bash
docker compose up --build
```

Isso vai:

- Subir os bancos PostgreSQL para cada API (`client-api` e `seguro-api`)
- Subir os containers das APIs (expondo as portas 8080 e 8081)
- Configurar rede compartilhada para comunicação interna

---

## Comunicação entre APIs

- A **Seguro API** consome a **Client API** via HTTP usando o hostname do container (`http://client_api:8080/api/clientes/{id}`), configurado pela variável de ambiente `CLIENT-API-URL`.
- Para garantir robustez, foi utilizado **Resilience4j** com Circuit Breaker e fallback, evitando falhas cascata entre os serviços.

---

## Estrutura do projeto

```
api-agibank/
│
├── client-api/
│   ├── src/
│   ├── Dockerfile
│   ├── .env/compose.env         # Variáveis de ambiente para client-api
│
├── seguro-api/
│   ├── src/
│   ├── Dockerfile
│   ├── .env/compose.env         # Variáveis de ambiente para seguro-api
│
├── docker-compose.yml
└── README.md
```

---

## Considerações finais

- **Mapper**: MapStruct para converter DTOs de entrada/saída em entidades de domínio, mantendo a camada de aplicação desacoplada da infraestrutura.
- **Configurações sensíveis**: Variáveis como URLs e credenciais ficam nos arquivos `.env/compose.env` e são carregadas no container via Docker Compose.
- **Testes**: Possui testes unitários focados na aplicação e na integração entre componentes, garantindo qualidade e previsibilidade.

---
