package controller;

import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

//Métodos para facilitar a utilização dos dados que vem do bando de dados
public class ProdutoController {

    private ProdutoDAO prodDAO = new ProdutoDAO();

    public List<Produto> produtos() {
        return prodDAO.emiteLista();
    }
/*
    public boolean cadastrarProdutoBD(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque,
            int estoqueMinimo, int estoqueMaximo, String nomeCategoria, String tamanho, String embalagem) {
        // adicionar ID
        Produto produto = new Produto(nomeProduto, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo,
                estoqueMaximo, nomeCategoria, tamanho, embalagem); //precisa arrumar o ID, o "tamanho" e a "embalagem"
        prodDAO.cadastrarProduto(nomeProduto, precoUnit, unidadeProduto, quantidadeEstoque,
                estoqueMinimo, estoqueMaximo, nomeCategoria, tamanho, embalagem);
        return true;
    }

    public boolean atualizarProdutoBD( int idProduto, String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque,
            int estoqueMinimo, int estoqueMaximo, String nomeCategoria, String tamanho, String embalagem) {
        Produto produto = new Produto(nomeProduto, idProduto, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo,
                estoqueMaximo, nomeCategoria, tamanho, embalagem); // precisa arrumar o "tamanho" e a "embalagem"
        prodDAO.atualizarProduto(produto);
        return true;
    }

    public boolean deletarProdutoBD(int idProduto) {
        prodDAO.deletarProduto(idProduto);
        return true;
    } */

}
