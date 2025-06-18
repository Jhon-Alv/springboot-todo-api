# Etapa 1: Compilación del proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw
# Agrega -DskipTests para saltar los tests
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen liviana con solo el JAR
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
