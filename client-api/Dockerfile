FROM maven:3.9.6-eclipse-temurin AS build
WORKDIR /app
COPY test /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar client_api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "client_api.jar"]
