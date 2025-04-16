# Usa a imagem oficial do Java 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo .jar para dentro do container
COPY target/client-0.0.1-SNAPSHOT.jar client-app.jar

# Expõe a porta usada pela aplicação Spring Boot
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "client-app.jar"]