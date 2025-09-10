# Start from an official Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml first to leverage caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies only (faster builds on subsequent runs)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of your source code
COPY src ./src

# Build the application (skip tests for faster builds)
RUN ./mvnw clean package -DskipTests

# Expose the default Spring Boot port
EXPOSE 8080

# Run the jar (Spring Boot fat jar)
CMD ["java", "-jar", "target/appointment-scheduler-0.0.1-SNAPSHOT.jar"]
