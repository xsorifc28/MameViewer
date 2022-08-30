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
    -Dsonar.projectKey=MameViewer-bff \
    -Dsonar.host.url=http://host.docker.internal:9000 \
    -Dsonar.login=sqp_3eefe5fe575ed40aa8f6ae7d4c0e088f36945710

FROM openjdk:18-alpine3.15

ENV HOME=/usr/app

ARG JAR_NAME="mameviewer-bff-0.0.1-SNAPSHOT"

WORKDIR /usr/src/app

EXPOSE 8080

COPY --from=build ${HOME}/target/${JAR_NAME}.jar ./app.jar

ENTRYPOINT java -jar ./app.jar