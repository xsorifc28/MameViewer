FROM node:18-slim

RUN npm install -g http-server

WORKDIR /app

COPY package*.json /

RUN npm install

COPY . .

RUN npm run build

EXPOSE 3000

ENTRYPOINT http-server dist -p 3000