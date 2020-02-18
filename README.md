# BASE MICROSERVICE

Arquitetura básica em microserviço

Nas próximas seções serão apresentados os requisitos e o procedimento para realizar o setup da aplicação.

## Requisitos

Para montar o ambiente do projeto é necessário:

* Java 8
* Maven
* Git

## Configuração do Backend

Este projeto foi desenvolvido utilizando a arquitetura de microsserviços e conta com vários módulos para seu completo funcionamento.

É necessário subir todos os módulos para a aplicação funcionar.

### Importando Dependências

Para importar as dependencias basta ir no pacote principal e rodar o comando abaixo:

    mvn package

### Discovery

Deve ser o primeiro módulo a ser iniciado. Este módulo que registra os microservices ativos, para acessar a lista de serviços registrado acesse 

    http://localhost:8081

Para iniciar o discovery fora da IDE, basta executar o comando abaixo dentro da pasta discovery:
 
    mvn spring-boot:run

### Trade-Service

Logo após o discovery já é possível iniciar o modulo principal o Trade-Service. Este módulo contém o crud de comércios.

Para iniciar o serviço trade-service fora da IDE, basta executar o comando abaixo dentro da pasta trade-service:
 
    mvn spring-boot:run

### Gateway

O ultimo módulo a ser iniciado é o gateway. Este módulo faz a ponte entre o frontend e os microservices no backend.

Para iniciar o gateway fora da IDE, basta executar o comando abaixo dentro da pasta gateway:
 
    mvn spring-boot:run

## Configurações dos projetos nas IDEs

Este projeto é um projeto Maven. Com isso, o processo de configuração dele é o padrão de qualquer projeto maven.

Basta importar um novo projeto maven apontando para o pom parent localizado na raíz do projeto.

Os demais detalhes de configurações fica a critério de cada IDE utilizada.

## Swagger

O projeto possui uma documentação para o serviço de comércio para acessar basta acessar a url abaixo

    http://localhost:8082/swagger-ui.html#/





