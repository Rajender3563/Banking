FROM ubuntu:latest
LABEL authors="rajenderkasarla"
# ---------- Build stage ----------
FROM gradle:8.10.2-jdk17 AS build
WORKDIR /app

# Copy Gradle project
COPY BankingBackend/ ./BankingBackend/

# Go inside the Gradle project folder
WORKDIR /app/BankingBackend

# Run build without tests
RUN gradle clean build -x test

# ---------- Runtime stage ----------
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy only the final jar from build stage
COPY --from=build /app/BankingBackend/build/libs/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
