# API REST CONTATOS E PESSOAS

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

### Este projeto é uma API REST em Java com Spring Boot, que permite gerenciar pessoas e seus contatos por meio de operações CRUD, a API permite cadastrar, consultar, atualizar e excluir registros de pessoas, além de gerenciar múltiplos contatos associados a cada uma delas.

## 💻 Tecnologias Utilizadas

Java 21

Spring Boot 3.4.2

JPA/Hibernate

Banco de Dados: H2

Swagger: OpenAPI

Postman

## 🚀 Funcionalidades

### CRUD de Pessoas:
   
a. Criar Pessoa

b. Obter Pessoa por ID

c. Obter Pessoa por ID para mala direta

d. Listar todas as Pessoas

e. Atualizar Pessoa por ID

f. Deletar Pessoa por ID


### CRUD de Contatos:

a. Adicionar um novo Contato a uma Pessoa

b. Obter Contato por ID

c. Listar todos os Contatos de uma Pessoa

d. Atualizar Contato por ID

e. Deletar Contato por ID

## ☕ Modelagem

### Pessoa: deve conter, pelo menos, os seguintes campos:

o ID (único, não pode ser nulo)

o Nome (não pode ser nulo)

o Endereço (pode ser nulo)

o CEP (pode ser nulo)

o Cidade (pode ser nulo)

o UF (pode ser nulo)


### Contato: deve conter, pelo menos, os seguintes campos:

o ID (único, não pode ser nulo)

o Tipo contato (não pode ser nulo) [inteiro]

o Contato (não pode ser nulo)

o Relacionamento com a entidade Pessoa (1 pessoa para vários contatos –
pesquisar relacionamento OneToMany e ManyToOne.

## 📫 Como executar o projeto

Clonar o repositório:

git clone https://github.com/luanfa03/AppPessoas.git

## 💻 Conexão com o banco de dados

### H2

application.properties:

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

spring.jpa.database-plataform=org.hibernate.dialect.H2Dialect

spring.jpa.show-sql=true

spring.jpa.hibernate.ddl-auto=drop-and-create

spring.datasource.url=jdbc:h2:mem:pessoas

spring.datasource.username=sa

spring.datasource.password=

## 💻 Executar projeto

http://localhost:8080/swagger-ui.html


## 🤝 Desenvolvido por:

<table>
  <tr>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://avatars3.githubusercontent.com/u/31936044" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Luan Fonseca</b>
        </sub>
      </a>
    </td>
</table>
