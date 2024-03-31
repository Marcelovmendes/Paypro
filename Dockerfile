FROM openjdk:21

WORKDIR /app

COPY target/*.jar app/paybackend.jar

CMD ["java", "-jar", "app/paybackend.jar"]
