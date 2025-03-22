#Etapa de construção
#FROM maven:3.4.3-openjdk-21 AS build
#FROM ubuntu:latest AS build
FROM openjdk:21-jdk-slim AS build
RUN apt-get update && apt-get-install -y maven && apt-get clean && rm -rf/var/lib/apt/lists/*

#Definir o diretório dentro do container para a aplicação
WORKDIR /app

#Copiar o pom.xml para o container
COPY pom.xml .
COPY src ./src

#Executar o Maven para compilar o projeto e gerar o arquivo JAR File
RUN mvn clean package -DskipTests

#Etapa de execução
FROM  openjdk:21-slim

#Definir o diretório e trabalho para a aplicação
WORKDIR /app

#Copiar o JAR construido na etapa anterior
COPY --from=build /app/target/*.jar app.jar

#Definir a porta que será ultilizada na aplicação
EXPOSE 8075

#Comando para executar a aplicação
ENTRYPOINT [ "java", "-jar", app.jar ]

