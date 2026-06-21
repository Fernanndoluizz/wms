# # WMS - Warehouse Management System

Sistema de gerenciamento de estoque desenvolvido em Java utilizando Spring Boot.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Git

## Funcionalidades

- ✅ Cadastro de produtos
- ✅ Listagem de produtos
- 🚧 Busca de produto por ID
- 🚧 Atualização de produtos
- 🚧 Movimentação de estoque
- 🚧 Usuários
- 🚧 Autenticação JWT

## Arquitetura

```
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

## Como executar

1. Clone o projeto

```bash
git clone https://github.com/Fernanndoluizz/wms.git
```

2. Abra no IntelliJ IDEA

3. Configure o PostgreSQL no `application.properties`

4. Execute a classe `WmsApplication`

## Autor

Luiz Fernando
