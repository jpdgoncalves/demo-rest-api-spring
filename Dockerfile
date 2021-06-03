FROM openjdk:11-jre-slim

WORKDIR /application

COPY target/demo-rest-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]