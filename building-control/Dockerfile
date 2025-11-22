# === Stage 1: Build the Spring Boot Application ===
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml separately to download dependencies first (faster Docker builds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy full source code
COPY src ./src

# Build the application (skipping tests to avoid time wastage)
RUN mvn clean package -DskipTests


# === Stage 2: Run the Application with a Lightweight JDK ===
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the jar built in Stage 1
COPY --from=build /app/target/*.jar building-control-0.0.1-SNAPSHOT.jar

# Expose backend port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "building-control-0.0.1-SNAPSHOT.jar"]
