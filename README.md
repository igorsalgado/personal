# Gerenciador de Pessoas

Este projeto é um exemplo de uma aplicação CRUD (Create, Read, Update, Delete) para gerenciar pessoas, construída utilizando as seguintes tecnologias: 

- Java 11
- Spring Boot MVC
- Thymeleaf
- JPA
- Banco de dados PostgreSQL

A aplicação permite criar, visualizar, atualizar e excluir pessoas do banco de dados. Cada pessoa é definida por um nome e idade.

## Requisitos

Para executar esta aplicação, você precisará dos seguintes requisitos:

- Java 11 instalado
- Maven instalado
- PostgreSQL instalado e configurado

## Configuração do Banco de Dados

Antes de executar a aplicação, você precisará configurar o banco de dados PostgreSQL. Siga os passos abaixo:

1. Crie um banco de dados chamado `pessoas` no PostgreSQL
2. Abra o arquivo `application.properties` localizado em `src/main/resources`
3. Edite as seguintes propriedades com as suas informações de banco de dados:

~~~properties
spring.datasource.url=jdbc:postgresql://localhost:5432/personal
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
~~~


## Executando a Aplicação

Para executar a aplicação, siga os passos abaixo:

1. Clone este repositório em sua máquina
2. Abra o terminal na pasta raiz do projeto
3. Execute o comando `mvn spring-boot:run`
4. Abra o navegador e acesse `http://localhost:8080/pessoas`
