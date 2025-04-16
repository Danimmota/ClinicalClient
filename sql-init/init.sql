CREATE DATABASE IF NOT EXISTS clinical_db;
USE clinical_db;

create table profissional (
	cpf_profissional VARCHAR(11) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	registro VARCHAR(20) NOT NULL,
	especializacao VARCHAR(50),
	rqe VARCHAR(15),
	email VARCHAR(50) NOT NULL,
	endereco VARCHAR(200),
	PRIMARY KEY (cpf_profissional),
	UNIQUE KEY (registro)
);

create table if not exists servico (
	id_servico INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(500) NOT NULL,
	PRIMARY KEY (id_servico),
	UNIQUE KEY (nome)
);

create table if not exists client (
	cpf_client VARCHAR(11) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	data_nascimento DATE NOT NULL,
	cep VARCHAR(50) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	complemento VARCHAR(20),
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY (cpf_client)
);

create table if not exists agenda (
	id_agenda INTEGER NOT NULL AUTO_INCREMENT,
	cpf_profissional VARCHAR(50) NOT NULL,
	data_hora_inicio DATETIME NOT NULL,
	data_hora_fim DATETIME NOT NULL,
	PRIMARY KEY (id_agenda)
);

create table if not exists agendamento (
	id_agendamento INTEGER NOT NULL AUTO_INCREMENT,
	servico_id INTEGER UNSIGNED NOT NULL,
	cpf_client VARCHAR(50) NOT NULL,
	id_agenda INTEGER NOT NULL,
	date_time DATETIME NOT NULL,
	PRIMARY KEY (id_agendamento),
	CONSTRAINT fk_agenda_agendamento FOREIGN KEY (id_agenda) REFERENCES agenda (id_agenda),
	CONSTRAINT fk_cliente_agendamento FOREIGN KEY (cpf_client) REFERENCES client (cpf_client),
	CONSTRAINT fk_servico_agendamento FOREIGN KEY (servico_id) REFERENCES servico (id_servico)
);

create table if not exists user (
	id_user CHAR(36) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	login VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(200) NOT NULL,
	perfil ENUM ('ADMIN', 'RECEPCIONISTA') NOT NULL DEFAULT 'ADMIN',
	criacao_usuario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id_user)
);

create table if not exists profissional_servico (
	profissional_id VARCHAR(50) NOT NULL,
	servico_id INTEGER UNSIGNED NOT NULL,
	PRIMARY KEY (profissional_id, servico_id),
	CONSTRAINT fk_profissional_servico FOREIGN KEY (profissional_id) REFERENCES profissional (cpf_profissional),
	CONSTRAINT fk_servico_profissional FOREIGN KEY (servico_id) REFERENCES servico (id_servico)
);

create table if not exists profissional_client (
	profissional_id VARCHAR(50) NOT NULL,
	client_id VARCHAR(50) NOT NULL,
	PRIMARY KEY (profissional_id, client_id),
	CONSTRAINT fk_profissional_client FOREIGN KEY (profissional_id) REFERENCES profissional (cpf_profissional),
	CONSTRAINT fk_client_profissional FOREIGN KEY (client_id) REFERENCES client (cpf_client)
);
