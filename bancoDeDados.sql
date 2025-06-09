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

CREATE TABLE IF NOT EXISTS movimentacao_estoque (
    idMovimentacao INT AUTO_INCREMENT PRIMARY KEY,
    tipoMovimentacao VARCHAR(20) NOT NULL,
    idProduto INT NOT NULL,
    quantidadeMovimentada INT NOT NULL,
    dataMovimentacao DATE NOT NULL,
    FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)
);
