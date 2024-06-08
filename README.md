# Microservices Project with Spring Boot and Spring Cloud

This project, located in the `example-microservice` branch, is a demonstration of a microservices architecture developed with Spring Boot, using Java 1.8 and Spring Cloud Hoxton.SR8. The initial version is 0.0.1-SNAPSHOT and includes three microservices: `payroll`, `server-eureka`, and `worker`. Each microservice is responsible for a specific part of the application and communicates with others through the Spring Cloud infrastructure.

## Technologies Used

### Payroll Microservice
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Feign Client

### Worker Microservice
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Spring Cloud Eureka Client

### Eureka Server
- Spring Boot 2.3.4.RELEASE
- Java 1.8
- Spring Cloud Hoxton.SR8
- Spring Cloud Eureka Server

## Database Configuration

The project uses an H2 database for demonstration purposes. Here are the inserts to add sample data to the database:

```sql
-- Worker Microservice
INSERT INTO worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO worker (name, daily_Income) VALUES ('Alex', 250.0);
```
## Microservices Configuration
Each microservice has its own configuration in an `application.yml` or `application.properties` file. Here are examples of the configurations for `payroll` and `worker`:

### Payroll Microservice `(application.yml)`

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

### Worker Microservice `(application.yml)`

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

### Eureka Server `(application.yml)`

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

## Using the Microservices

- The `payroll` microservice uses the Feign Client to communicate with the `worker` microservice and call specific endpoints.
- The `worker` microservice provides worker data and is registered with the Eureka server so that other microservices can find it.
- The Eureka server acts as a central registry for all microservices and allows them to discover each other.

## Project Structure

The project follows an organized structure with folders for controlling entities, services, controllers, configurations, and security in each microservice.

## Authors and Contributors

Rayana Ribeiro Bonfanti

## Project Status

Current version: 0.0.1-SNAPSHOT

## Contact

For more information, contact [rayanabonfanti@gmail.com].

## Contributions

Feel free to contribute to this project by adding features, fixing bugs, or improving authentication security. Once done, you can open a pull request, and I will review the code for a potential branch to be added with your changes. Your contribution is welcome!

We thank everyone who contributed and inspired us to create this project.

This is an example project aimed at helping understand microservices architecture with Spring Boot and Spring Cloud. It is a solid foundation for creating more complex applications with microservices features and inter-service communication.

