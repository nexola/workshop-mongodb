# Projeto API Restful com Spring Boot e MongoDB

# Sobre o projeto

Projeto CRUD com Restful, Spring Boot e banco de dados Mongo, possuindo implementação de consultas personalizadas com Spring Data e MongoRepository.

## Modelo de domínio
![image](https://github.com/nexola/workshop-mongodb/assets/103954392/c901a97b-1af3-4bab-9674-a819cc4cf99c)

## JSON
![json](https://github.com/nexola/workshop-mongodb/assets/103954392/718db40d-8e05-42b1-881e-82b0e195fd1d)

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
