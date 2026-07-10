FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar merchant-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","merchant-service.jar"]