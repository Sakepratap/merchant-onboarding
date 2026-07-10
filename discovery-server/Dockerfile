FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar discovery-server.jar

ENTRYPOINT ["java","-jar","discovery-server.jar"]