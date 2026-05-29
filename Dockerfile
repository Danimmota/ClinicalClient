# Usa a imagem oficial do Java 17
FROM alpine:latest

# Instala o OpenJDK 17
RUN apk add --no-cache openjdk17

# Define diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Dá permissão ao mvnw
RUN chmod +x mvnw

# Builda a aplicação
RUN ./mvnw clean package -DskipTests

# Renomeia o jar gerado
RUN cp target/client-0.0.1-SNAPSHOT.jar client-app.jar

# Expõe a porta
EXPOSE 8081

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "client-app.jar"]