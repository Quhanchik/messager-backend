FROM maven:3.8.5-openjdk-17-slim AS build

ADD . /src

WORKDIR /src

RUN mvn clean package

EXPOSE 8080

ENTRYPOINT ["java","-jar","./target/fakewhatsapp-0.0.1-SNAPSHOT.jar"]