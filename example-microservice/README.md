# Projeto de Microserviços com Spring Boot e Spring Cloud

Este projeto, localizado na branch `example-microservice`, é uma demonstração de uma arquitetura de microserviços desenvolvida em Spring Boot, utilizando Java 1.8 e Spring Cloud Hoxton.SR8. A versão inicial é 0.0.1-SNAPSHOT e inclui três microserviços: `payroll`, `server-eureka` e `worker`. Cada microserviço é responsável por uma parte específica da aplicação e se comunica com os outros por meio da infraestrutura do Spring Cloud.

## Tecnologias Utilizadas

### Microserviço Payroll
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Feign Client

### Microserviço Worker
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Spring Cloud Eureka Client

### Servidor Eureka
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Spring Cloud Eureka Server

## Configuração do Banco de Dados

O projeto utiliza um banco de dados H2 para fins de demonstração. Aqui estão os inserts para inserir dados de exemplo no banco:

```sql
-- Microserviço Worker
INSERT INTO worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO worker (name, daily_Income) VALUES ('Alex', 250.0);
```

## Configuração dos Microserviços

Cada microserviço tem sua própria configuração em um arquivo `application.yml` ou `application.properties`. Aqui estão exemplos das configurações para `payroll` e `worker`:

### Microserviço Payroll `(application.yml)`

```yml
spring:
  application:
    name: microservice-payroll
server:
  port: ${PORT:0}
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    instance-id: ${spring.application.name}:${spring.application.name:${random.value}}
```
### Microserviço worker `(application.yml)`

```yml
spring:
    application:
    name: microservice-worker
    h2:
    console:
      enabled: true
      path: /h2-console
server:
    port: ${PORT:0}
eureka:
    client:
        service-url:
            defaultZone: http://localhost:8761/eureka
instance:
    instance-id: ${spring.application.name}:${spring.application.name:${random.value}}

# Database configuration
spring.datasource:
    url: jdbc:h2:mem:db_worker
    username: username_db_worker
    password: password_db_worker
    
```

### Microserviço server eureka `(application.yml)`

```yml
spring:
  application:
    name: microservice-server-eureka
  server:
    port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

## Uso dos Microserviços

- O microserviço `payroll` utiliza o Feign Client para se comunicar com o microserviço `worker` e chamar endpoints específicos.
- O microserviço `worker` fornece dados de trabalhadores e é registrado no servidor Eureka para que outros microserviços possam encontrá-lo.
- O servidor Eureka atua como um registro central para todos os microserviços e permite que eles se descubram.

## Estrutura do Projeto

O projeto segue uma estrutura organizada com pastas para controle de entidades, serviços, controladores, configurações e segurança em cada microserviço.

## Autores e Contribuidores

Rayana Ribeiro Bonfanti

## Status do Projeto

Versão atual: 0.0.1-SNAPSHOT

## Contato

Para mais informações, entre em contato com [rayanabonfanti@gmail.com].

## Contribuições

Fique à vontade para contribuir para este projeto, seja adicionando recursos, corrigindo bugs ou aprimorando a segurança da autenticação, assim que feito, pode abrir um pull request que irei analisar o código para uma possível branch ser adicionada com suas alterações. Sua contribuição é bem-vinda!

Agradecemos a todos que contribuíram e nos inspiraram a criar este projeto.

Este é um projeto de exemplo que visa ajudar a compreender a arquitetura de microserviços com Spring Boot e Spring Cloud. É uma base sólida para criar aplicativos mais complexos com recursos de microserviços e comunicação entre eles.
