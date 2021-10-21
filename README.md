# create the project - managerpeople-api

Simple project with API REST about manager people system.


## Como executar o projeto, digite o seguite comando

```sh
  mvn spring-boot:run
  ```

## Tecnologias Utilizadas 

    O projeto foi desenvolvido utilizando as seguintes tecnologias.

- [Spring Boot](https://spring.io/)
- [Apache Tomcat](http://tomcat.apache.org/)
- [Maven](https://maven.apache.org/)
- [Insomnia](https://insomnia.rest/download)
- [H2](https://www.h2database.com/html/main.html)


## Requisições Json

GET
```
http://localhost:8080/api/v1/people
```

POST
```
http://localhost:8080/api/v1/people
```


PUT
```
http://localhost:8080/api/v1/people/1
```


DELETE
```
http://localhost:8080/api/v1/people/1
```


##  Como baixar o projeto
```bash
# Clonar o repositório
$ git clone git@github.com:yurihallan/managementpeople-api.git
# Entrar no diretório
$ cd managementpeople-api
# Importar projeto através do VSCODE (ou IDE de sua preferência)
# Se precisar importar as dependências antes de executar o projeto, rode
$ mvn clean install
# Iniciar o projeto execute 
$ mvn spring-boot:run
# Podendo rodar a aplicação com a extensão do Extension Pack for Java v0.18.5 no VSCODE, outras IDE tem um botão para executar a aplicação java.
```