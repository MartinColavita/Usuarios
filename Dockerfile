# FROM: imagen base jdk 17 java
FROM openjdk:17-jdk-alpine3.13

MAINTAINER martincolavita@gmail.com

# Copia el jar generado
COPY target/Usuarios-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]