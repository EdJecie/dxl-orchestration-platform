FROM ubuntu:latest
LABEL authors="Administrator"

ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

