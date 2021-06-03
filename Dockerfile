FROM maven:3.8.1-openjdk-11

WORKDIR /application

COPY target/demo-rest-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]