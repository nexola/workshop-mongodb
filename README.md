# Projeto API Restful com Spring Boot e MongoDB

# Sobre o projeto

Projeto CRUD com Restful, Spring Boot e banco de dados Mongo, possuindo implementação de consultas personalizadas com Spring Data e MongoRepository.

## Modelo de domínio
![2](https://github.com/nexola/workshop-spring-boot-mongodb/assets/103954392/6dc89106-f453-4d68-88c5-3c7049b5fc8e)

## Associações e retorno em JSON
![3](https://github.com/nexola/workshop-spring-boot-mongodb/assets/103954392/e4d0e3e7-443d-4854-bd5a-3c54e1408de0)

# Tecnologias utilizadas
- Java
- Mongo DataBase
- Spring Boot
- Restful

# Endpoints
## User
### GET /users
> Retorna todos os usuários

### GET /users/{id}
> Retorna usuário pelo id

### GET /users/{id}/posts
> Retorna todos posts de um usuário

### POST /users
> Insere um usuário

### PUT /users/{id}
> Atualiza um usuário

### DEL /users/{id}
> Deleta um usuário

## Post
### GET /posts/{id}
> Retorna um post pelo id

### GET /posts?title=
> Retorna todos os posts com filtro por texto no título

### GET /posts/fullsearch?text={text}&start={instant}&end={instant}
> Retorna todos os posts com filtro por texto no título, corpo e comentários, e intervalo de datas

# Autor

Vitor Matheus Ferreira Vianna

https://www.linkedin.com/in/vitor-vianna-a53075215
