
# Use an official OpenJDK image as the base image
FROM openjdk:8-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/gestion-station-ski-1.0.jar /app/gestion-station-ski-1.0.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8089

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "gestion-station-ski-1.0.jar"]