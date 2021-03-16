# Modern Java

This is a toy project set up demonstrate some of the key difference between old school Java and the newer more functional java 8.
In particular the Stream API and functional interfaces are touched on. The project can be built with maven and uses Spring to provide a REST API
which can be use to trigger various different sorting and filtering behaviour on a very humble data set of apples.

#### Start service
*Navigate to project root via command line and execute.*
```bash
mvn spring-boot:run
```

#### Swagger API
```bash
http://localhost:8888/swagger-ui.html
```

#### H2 Console
```bash
http://localhost:8888/h2-console
```
