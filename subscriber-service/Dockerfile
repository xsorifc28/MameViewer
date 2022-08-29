FROM maven:3.8.6-openjdk-18-slim AS build

ENV HOME=/usr/app

RUN mkdir -p $HOME

WORKDIR $HOME

ADD . $HOME

RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml \
    clean \
    verify \
    sonar:sonar \
    package \
    -Dsonar.projectKey=MameViewer-subscriber \
    -Dsonar.host.url=http://host.docker.internal:9000 \
    -Dsonar.login=sqp_3624b791b4b0543dc8f77a6dae82fe1420ce0c6d

FROM openjdk:18-alpine3.15

ENV HOME=/usr/app

ARG JAR_NAME="MameViewer-Subscriber-1.0-SNAPSHOT-jar-with-dependencies"

WORKDIR /usr/src/app

EXPOSE 9090

COPY --from=build ${HOME}/target/${JAR_NAME}.jar ./app.jar

ENTRYPOINT java -jar ./app.jar