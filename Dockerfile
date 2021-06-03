FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/challenge-0.1.jar .

EXPOSE 8080

CMD ["java", "-jar", "challenge-0.1.jar"]