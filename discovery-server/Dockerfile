# Use Eclipse Temurin JDK 22 Alpine base
FROM eclipse-temurin:22-jdk-alpine

# Install netcat for connectivity testing
RUN apk update && apk add --no-cache netcat-openbsd

WORKDIR /discovery-server
COPY target/discovery-server.jar discovery-server.jar

# Force Spring Boot to use docker profile
ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 9090

ENTRYPOINT ["java","-jar","discovery-server.jar"]