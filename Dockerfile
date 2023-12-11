# Use an official Maven image as a parent image
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY pom.xml .
COPY src ./src

# Build the application JAR
RUN mvn clean package

# Use an official OpenJDK runtime as the final image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/target/*.jar /app/spring-boot-app.jar

# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "spring-boot-app.jar"]
