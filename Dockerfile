FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/ski.jar  ski.jar
#COPY target/ski.jar/ski.jar
ENTRYPOINT ["java", "-jar", "/ski.jar"]
