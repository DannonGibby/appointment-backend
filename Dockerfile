# Use a Maven image to build the project
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (cache them)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Use a minimal JDK image to run the app
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the jar built in the previous stage
COPY --from=build /app/target/appointment-scheduler-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java","-jar","app.jar"]
