#syntax=docker/dockerfile:1.4
FROM node:18-slim

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

COPY --from=proto_source . .

EXPOSE 9091

ENTRYPOINT node src/server.js