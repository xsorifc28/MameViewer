# MameViewer

MameViewer is a mock streaming platform that demonstrates the use of well-tested microservice development in a cloud 
environment using Protocol Buffers (protobuf) and gRPC.

## Presentation

A [slide deck](https://xsorifc28.github.io/MameViewer) is available for those who wish to familiarize themselves with
the tech stack of this repository.

## Services

| Service                                | Language    | Purpose                   |  
|----------------------------------------|-------------|---------------------------|
| [Subscriber](./subscriber-service)     | Java        | Manage Subscribers        |
| [Entitlements](./entitlements-service) | Node        | Manage Entitlements       |
| [Content](./content-service)           | Go          | Manage Streamable Content |
| [BFF](./bff-service)                   | Java/Spring | Backend for frontend      |
| [Frontend](./frontend-service)         | Vue         | Consumer application      |

## Getting Started
WIP

## Learn More
- [Protobuf](https://developers.google.com/protocol-buffers)
- [gRPC Guides](https://grpc.io/)
- [maven](https://maven.apache.org/guides/getting-started/)
- [Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Docker](https://docs.docker.com/get-started/)
- [SonarQube Intro](https://www.bitslovers.com/how-to-use-sonarqube-with-docker-and-maven/)
