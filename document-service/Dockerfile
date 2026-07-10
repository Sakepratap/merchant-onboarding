FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar document-service.jar

ENTRYPOINT ["java","-jar","document-service.jar"]