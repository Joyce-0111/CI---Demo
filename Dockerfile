# Use OpenJDK base image
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the jar from target
COPY target/ci-demo-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]