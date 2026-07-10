FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar api-gateway.jar

ENTRYPOINT ["java","-jar","api-gateway.jar"]