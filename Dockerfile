# Utilisez une image de base appropriée
FROM openjdk:8-jdk-alpine

# Exposez le port 8080 pour l'application
EXPOSE 8080

# Créez le répertoire /app dans le conteneur
RUN mkdir /app

# Copiez le fichier jar dans le conteneur
COPY ./target/gestion-station-ski-1.0.jar /app/gestion-station-ski-1.0.jar

# Commande d'exécution pour lancer l'application
CMD ["java", "-jar", "/app/gestion-station-ski-1.0.jar"]
