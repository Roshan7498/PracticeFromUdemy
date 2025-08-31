# Use Eclipse Temurin JDK 22 Alpine base
FROM eclipse-temurin:22-jdk-alpine

# Install netcat for connectivity testing
RUN apk update && apk add --no-cache netcat-openbsd

WORKDIR /meraApp
COPY target/apnaapp.jar tanishi.jar

# Force Spring Boot to use docker profile
ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 9090

ENTRYPOINT ["java","-jar","tanishi.jar"]


