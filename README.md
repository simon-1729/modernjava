# Modern Java

### Details
This is a demo project used to highlight some of the key features of java 8. In particular, we focus on the Stream API and functional interfaces.
The project leverages Spring and Swagger to provide a simple RESTful API which may be use to sort and filter the baked-in Apple dataset.
For comparison we have included both Legacy and Modern implementations.

### Build source code
```bash
mvn clean package spring-boot:repackage
```

### Start service
##### *Navigate to project root via command line and execute.*
```bash
mvn spring-boot:run
```

### Swagger API
```bash
http://localhost:8888/swagger-ui.html
```

### H2 Console
##### *See application.properties for login details.*
```bash
http://localhost:8888/h2-console
```

___


### Optional 
##### Build and tag a Docker image
```bash
docker build -t simon1729/modernjava .
```

##### Start Docker container.
```bash
docker run -d -p 8888:8888 --name modernjava simon1729/modernjava
```
