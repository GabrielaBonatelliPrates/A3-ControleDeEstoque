CREATE DATABASE IF NOT EXISTS controle_estoque_A3;

USE controle_estoque_A3;

CREATE TABLE IF NOT EXISTS produtos (
    idProduto INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    preco_unitario DOUBLE NOT NULL,
    unidade VARCHAR(50) NOT NULL,
    estoque_atual INT NOT NULL,
    estoque_minimo INT NOT NULL,
    estoque_maximo INT NOT NULL,
    nome_categoria VARCHAR(100) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    embalagem VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS categorias (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nomeCategoria VARCHAR(100) NOT NULL,
    tamanho VARCHAR(50) NOT NULL,
    embalagem VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS movimentacao (
	idMovimentacao INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    tipoMovimentacao VARCHAR (50) NOT NULL,
    quantidadeMovimentada INT NOT NULL,
    dataMovimentacao date NOT NULL,
    idProduto INT NOT NULL
    );
    
    ALTER TABLE movimentacao
		ADD FOREIGN KEY (idProduto) REFERENCES produtos (idProduto);