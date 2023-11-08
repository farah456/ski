FROM openjdk:11
COPY target/gestion-station-ski-1.0.jar /app/gestion-station-ski-1.0.jar
EXPOSE 8089
CMD ["java", "-jar", "gestion-station-ski-1.0.jar"]