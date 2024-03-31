FROM openjdk:21

WORKDIR /app

COPY target/pay-backend-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "pay-backend-0.0.1-SNAPSHOT.jar"]
