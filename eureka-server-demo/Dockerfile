FROM maven:latest as build

WORKDIR /app

COPY . /app

RUN mvn -DskipTests=true install

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/eureka-server-demo-0.0.1-SNAPSHOT.jar /app/run.jar

ENTRYPOINT [ "java", "-jar", "run.jar"]



