# 🏥 Clinical 
## Sistema de Gerenciamento de Clinica

### Objetivo

Este projeto foi desenvolvido com o objetivo de facilitar o dia a dia de clínicas que possuem diversos profissionais de diferentes especialidades. A aplicação oferece um ambiente unificado para o gerenciamento completo da clínica, incluindo agendamentos, controle de profissionais, envio de e-mails e muito mais. 

Esta aplicação tem como objetivo ser uma *API RESTfull* capaz de fornecer endpoints para o gerenciamento de.

## 📋 Descrição do Sistema

O sistema permite:

- Gerenciamento completo de profissionais e usuários administrativos.
- Agendamento de consultas, exames e outros serviços diversos.
- Envio automático de e-mails aos clientes confirmando ou cancelando agendamentos.
- Integração com sistemas de mensageria para comunicação entre serviços.
- Infraestrutura baseada em containers para fácil escalabilidade e manutenção.

### ⚙️ Funcionalidades já implementadas

- Cadastro, edição, listagem e exclusão de profissionais.
- Cadastro e gerenciamento de usuários administrativos.
- Criação de agendamento de serviços com envio automático de e-mail.
- Sistema testado via Postman com abordagem orientada a testes (TDD).

### 🛠️ Melhorias Futuras

- Implementação de autenticação e autorização com Spring Security e tokens JWT.
- Cancelamento de agendamentos com notificação ao cliente via e-mail.
- Finalização dos CRUDs de:
    - Agendas médicas
    - Agendamentos
    - Clientes
    - Serviços

---

## 🧰Tecnologias utilizadas

### Linguagem & Arquitetura

- **Java**
- **Arquitetura MVC (Model - View - Controller)**

### Frameworks & Dependências Spring
- `Spring Boot DevTools` - Hot reload para facilitar o desenvolvimento.
- `Lombok` - Redução de boilerplate (getters/setters, etc).
- `Spring Web` - Criação de endpoints RESTful.
- `Spring Data JPA` - Integração com banco de dados relacional via ORM.
- `Spring Validation` - Validação de dados de entrada.
- `Spring MySQL` - Conectividade com banco de dados MySQL.
- `Spring AMQP` - Comunicação assíncrona com RabbitMQ.
- `Spring Mail Sender` - Envio de e-mails automáticos.

### Banco de Dados e Mensageria

- `MySQL` - Sistema Gerenciador de Banco de Dados relacional.
- `RabbitMQ` - Sistema de mensageria para comunicação entre serviços.

### Ferramentas e Testes

- `Docker` - Contêineres para infraestrutura da aplicação.
- `Postman` - Testes de API REST.
- `TDD` - Desenvolvimento orientado a testes.

___

## 🚀 Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter os seguintes itens instalados em sua máquina:

- Java 17 ou superior
- Maven
- Docker e Docker Compose
- Git

### Passos para execução

1. **Clone o repositório**

- Necessário seguir os mesmos passos no repositório de email

```bash

git clone https://github.com/Danimmota/ClinicalClient.git
cd ClinalClient

```
2. **Configure o ambiente com Docker**

Na raiz do projeto, execute:
```bash

docker-compose up -d

```
Isso irá instanciar os containers do MySQL e RabbitMQ.

3. **Execute a aplicação**

Com o ambiente configurado, execute o projeto utilizando sua IDE preferida (IntelliJ, Eclipse, VS Code).

4. **Testes com Postman**

Teste os endpoints disponíveis para verificar funcionalidades de agendamento, cadastro, etc.

___


| BASEPATH  | /profissionais                  |
|-----------|---------------------------------|
| POST      | /profissionais                  |
| GETALL    | profissionais/listar            |
| GETBYID   | profissionais/{cpfProfissional} |
| GETBYNOME | profissionais/nome              |
| GETBYESPECIALIZACAO | profissionais/especializacao    |
| PUT       | profissionais/{cpfProfissional} |
| DELETE    | profissionais/{cpfProfissional} |

## BasePath: /profissionais

### 1. Criação de um profissional
- Método: *POST* 
- Endpoint:https://localhost:8081/profissionais
- BodyParams (Json):
- Ex body:
```
{
    "cpf_profissional": "09802489654",
    "nome": "Ana Cecilia",
    "telefone": "'(61)22222222",
    "registro":"524695DF",
    "especializacao": "Dermatologista",
    "rqe":"564896",
    "email": "anacecilia@yahoo.com",
    "endereco":"Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
}
```
- Ex response:
- - Status: 201 Created 
```
{
    "cpf_profissional": "09802489654",
    "nome": "Ana Cecilia",
    "telefone": "'(61)22222222",
    "registro":"524695DF",
    "especializacao": "Dermatologista",
    "rqe":"564896",
    "email": "anacecilia@yahoo.com",
    "endereco":"Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
}
```
## 2. Buscar a lista de todos os profissionais cadastrados
- Método *GET*:
- Endpoint: /profissionais/listar
- Ex chamada:https://localhost:8081/profissionais/listar
- Ex response:
```
{
    {
        "cpf_profissional": "09802489654",
        "nome": "Ana Cecilia",
        "telefone": "(61)22222222",
        "registro": "569895DF",
        "especializacao": "Nutrologa",
        "rqe": "564896",
        "email": "daniela.mota@yahoo.com.br",
        "endereco": "Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
    },
    {
        "cpf_profissional": "26460318409",
        "nome": "Jose da Silva",
        "telefone": "(61)996482536",
        "registro": "365896DF",
        "especializacao": "Endocrinologista",
        "rqe": "564896",
        "email": "ismaelptu@hotmail.com",
        "endereco": "Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
    }
}
```

### 3. Busca um profissional pelo Id(cpf_profissional)
- Método *GET*: 
- Endpoint: /profissionais/{cpfProfissional}
- QueryParams: cpf_profissional (VARCHAR(11))
- Ex chamada:https://localhost:8081/profissionais/26460318409
- Ex response:
```
{
 "cpf_profissional": "26460318409",
    "nome": "Jose da Silva",
    "telefone": "(61)996482536",
    "registro": "365896DF",
    "especializacao": "Endocrinologista",
    "rqe": "564896",
    "email": "ismaelptu@hotmail.com",
    "endereco": "Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
}
```
## 4. Busca um profissional pelo Nome
- Método *GET*:
- Endpoint: /profissionais/nome
- QueryParams: nome(VARCHAR)
- Ex chamada:https://localhost:8081/profissionais/nome?nome=Jose da Silva
- Ex response:
```
{
    "cpf_profissional": "26460318409",
    "nome": "Jose da Silva",
    "telefone": "(61)996482536",
    "registro": "365896DF",
    "especializacao": "Endocrinologista",
    "rqe": "564896",
    "email": "ismaelptu@hotmail.com",
    "endereco": "Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"
}
```

## 5. Busca uma lista de profissionais pela especialização
- Método *GET*:
- Endpoint: /profissionais/especializacao
- QueryParams: especializacao(VARCHAR)
- Ex chamada: https://localhost:8081/profissionais/especializacao?especializacao=Endocrinologista
- Ex response:
```
{
     "cpf_profissional": "26460318409",
     "nome": "Jose da Silva",
     "telefone": "(61)996482536",
     "registro": "365896DF",
     "especializacao": "Endocrinologista",
     "rqe": "564896",
     "email": "ismaelptu@hotmail.com",
     "endereco": "Rua 05 Quadra 20, Bairro Itapoã, Brasília, Distrito Federal"

}
```

## 6. Atualiza um cadastro de um profissional
- Método *PUT*:
- Endpoint: /profissionais/{cpfProfissional}
- QueryParams: cpf_profissional (VARCHAR(11))
- Ex chamada:https://localhost:8081/profissionais/09802489654
- Ex response:
```
{
    "cpf_profissional": "09802489654",
    "nome": "Ana Cecilia",
    "telefone": "(61)22222222",
    "registro": "569895DF",
    "especializacao": "Nutrologa",
    "rqe": "564896",
    "email": "daniela.mota@yahoo.com.br",
    "endereco": "Rua 03 Quadra 20, Bairro AsaSul, Brasília, Distrito Federal"
}
```

## 7. Deleta um profissional 
- Método *DELETE*:
- Endpoint: /profissionais/{cpfProfissional}
- QueryParams: cpf_profissional (VARCHAR(11))
- Ex chamada: https://localhost:8081/profissionais/09802489654
- Ex response: 
```
Profissional excluído com sucesso!
```
___

| BASEPATH  | /agendamentos |
|-----------|---------------|
| POST      | /agendamentos |

## BasePath: /agendamentos

### 1. Criação de um agendamento
- Método: *POST*
- Endpoint:https://localhost:8081/agendamentos
- BodyParams (Json)
- Ex body:
```
{
    "servico_id": "",
	"cpf_client": "",
	"id_agenda": "", 
}
```
___
## 📬Contato

- Email: danielamedeiromota@hotmail.com
- linkedin: https://www.linkedin.com/in/danielammota/
- GitHub: https://github.com/Danimmota