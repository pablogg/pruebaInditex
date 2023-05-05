
[![N|Java](https://d33wubrfki0l68.cloudfront.net/f8099f57973f45c668f8cf7d7c3e8987e81dd93d/9b944/assets/img/news/java-note.png)](https://www.java.com)

## Decisions

- We use Spring Data JPA to access the database.

- I have used H2 as the database, because it is the one indicated in this exercise, but the database could be changed very quickly without any problem. (MongoDB, SQL, etc).

- Use of Hexagonal Architecture, since it allows us to create applications that are easier to understand, maintain, evolve and test.

- Security has not been implemented, since the exercise does not ask for it, but we could use Spring Security if necessary.

- Unit and integration tests have been carried out using Test Unit and Mockito.

- A Postman file has also been added to be able to automate tests if necessary.


## Run application
 
Build project with maven:
```sh
mvn clean package
```

Build Base Docker image:
```sh
docker build -t inditex:1.0.0 -f docker/Dockerfile ./target/
```

Run the application in a container:

```sh
docker run -d -p 8080:8080 -t inditex:1.0.0
```
Swagger url:
```sh
http://localhost:8080/inditex/swagger-ui/index.html#/
```


## Postman
![logo](https://raw.githubusercontent.com/alisonhall/postman-introduction/master/assets/logo.png)

Here you can find the postman file to launch the tests [link](https://github.com/pablogg/pruebaInditex/blob/develop/PruebaInditex.postman_collection.json).


## Architecture

Hexagonal architecture, also known as Ports and Adapters architecture, is a software architecture pattern that emphasizes loose coupling and modularity. It consists of three main layers:

- Domain layer: This is the innermost layer and contains the core business logic and rules of the application. It encapsulates the domain model and entities, which represent the concepts and rules of the problem domain.

- Application layer: This layer serves as an interface between the domain layer and the external systems or dependencies. It contains application-specific logic that uses the domain model to provide functionality to the end-users. This layer is also responsible for coordinating transactions, security, and other cross-cutting concerns.

- Infrastructure layer: This layer contains the implementation details of the ports and adapters, such as databases, network protocols, and other external systems. It provides the necessary interfaces for the application layer to communicate with external systems, and adapts these systems to the interfaces defined by the ports.


### Info compilation maven and docker version
Docker:
```sh
    Client: Docker Engine - Community
    Version:           20.10.21
    API version:       1.41
    Go version:        go1.18.7
    Git commit:        baeda1f
    Built:             Tue Oct 25 18:02:21 2022
    OS/Arch:           linux/amd64
    Context:           default
    Experimental:      true

    Server: Docker Engine - Community
    Engine:
    Version:          20.10.21
    API version:      1.41 (minimum version 1.12)
    Go version:       go1.18.7
    Git commit:       3056208
    Built:            Tue Oct 25 18:00:04 2022
    OS/Arch:          linux/amd64
    Experimental:     false
    containerd:
    Version:          1.6.9
    GitCommit:        1c90a442489720eec95342e1789ee8a5e1b9536f
    runc:
    Version:          1.1.4
    GitCommit:        v1.1.4-0-g5fd4c4d
    docker-init:
    Version:          0.19.0
    GitCommit:        de40ad0
```

Maven:
```sh
    Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
    Maven home: C:\apache-maven-3.6.0
    Java version: 11.0.16.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.16.1
    Default locale: en_US, platform encoding: Cp1252
```
