DROP DATABASE IF EXISTS oficina_desktop;

CREATE SCHEMA oficina_desktop;
CREATE DATABASE oficina_desktop;

USE oficina_desktop;

CREATE TABLE pessoa (
	idpessoa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf CHAR(14),
    dt_nascimento DATE,
    telefone VARCHAR(200),
    email VARCHAR(255)    
);

CREATE TABLE cliente (
	idcliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idpessoa INT,
	rua VARCHAR(255),
    bairro VARCHAR(255),
    cep CHAR(9),
    estado VARCHAR(255),
    FOREIGN KEY (idpessoa) REFERENCES pessoa(idpessoa)
);

CREATE TABLE carro (
	idcarro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idcliente INT,
	modelo VARCHAR(255),
    marca VARCHAR(255),
    ano CHAR(4),
    placa VARCHAR(14),
    FOREIGN KEY (idcliente) REFERENCES cliente(idcliente)
);
    
CREATE TABLE profissional (
	idprofissional INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idpessoa INT,
    funcao VARCHAR(255),
    dt_admissao DATE,
    FOREIGN KEY (idpessoa) REFERENCES pessoa(idpessoa)
);
    
CREATE TABLE orcamento (
	idorcamento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idprofissional INT,
    idcarro INT,
    tempo_manutencao VARCHAR(10),
    pecas VARCHAR(255),
    valor_trabalho INT,
    valor_total INT,
    situacao VARCHAR(70),
    FOREIGN KEY (idcarro) REFERENCES carro(idcarro)
);
    
use oficina_desktop;
    
    
