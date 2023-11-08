FROM openjdk:11

# Install curl
RUN apt-get update && apt-get install -y curl

WORKDIR /app

# Start the application
CMD ["sh", "-c", "curl -o gestion-station-ski-1.0.jar -u jenkins-user:admin http://192.168.1.3:8081/repository/projectTest/tn/esprit/spring/gestion-station-ski/1.0/gestion-station-ski-1.0.jar && java -jar gestion-station-ski-1.0.jar"]

EXPOSE 8089
