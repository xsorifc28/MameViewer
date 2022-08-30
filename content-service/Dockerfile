FROM golang:1.19-alpine

WORKDIR /app

COPY go.mod ./
COPY go.sum ./

RUN go mod download

COPY generated generated
COPY src src

RUN go build -o /server src/server.go

EXPOSE 9092

ENTRYPOINT /server
