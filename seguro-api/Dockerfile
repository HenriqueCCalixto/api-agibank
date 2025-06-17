FROM maven:3.9.6-eclipse-temurin AS build
WORKDIR /app
COPY api /app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:24-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar seguro_api.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "seguro_api.jar"]
