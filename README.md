
[![N|Java](https://d33wubrfki0l68.cloudfront.net/f8099f57973f45c668f8cf7d7c3e8987e81dd93d/9b944/assets/img/news/java-note.png)](https://www.java.com)

### Run application
 
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


