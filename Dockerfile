# Exposez un port
EXPOSE 8080

# Copiez les fichiers de votre application dans le conteneur
ADD target/gestion-station-ski-1.0.jar /app/gestion-station-ski-1.0.jar
# Commande d'exécution
CMD ["java", "-jar", "/app/gestion-station-ski-1.0.jar"]
