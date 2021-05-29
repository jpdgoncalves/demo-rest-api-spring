FROM maven:3.8.1-openjdk-11

WORKDIR /application

COPY . .

RUN mvn package

CMD ["java", "-jar", "target/demo-rest-api-0.0.1-SNAPSHOT.jar"]