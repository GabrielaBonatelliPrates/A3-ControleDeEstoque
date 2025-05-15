package model;
import java.util.List;
import java.util.ArrayList;

public class Relatorios {

    private List<List<String>> lista;
    private int NumeroLinhas;

    public Relatorios() {
        this.lista = new ArrayList<>();
        this.lista.add(new ArrayList<>()); // Adiciona a primeira linha da tabela
        this.NumeroLinhas = 0;
    }

    public void addElement(String elemento) {
        if (NumeroLinhas >= 8) {
//Cria nova linha quando a ultima adicionada foi preenchida.
        lista.add(new ArrayList<>());
            NumeroLinhas = 0;
        }

        // Adiciona um elemento à linha atual.
        lista.get(lista.size() - 1).add(elemento);
        NumeroLinhas++;
    }

    public void adicionarCabecalho() {
        addElement("Nome");
        addElement("Preço Unitário");
        addElement("Unidade de Produto");
        addElement("Quantidade em Estoque");
        addElement("Quantidade em Estoque mínima");
        addElement("Quantidade em Estoque máxima");
        addElement("ID");
        addElement("Categoria");
    }

    public void adicionarProduto(Produto produto) {
        addElement(produto.getNomeProduto());
        addElement(String.valueOf(produto.getPrecoUnit()));
        addElement(produto.getUnidadeProduto());
        addElement(String.valueOf(produto.getQuantidadeEstoque()));
        addElement(String.valueOf(produto.getEstoqueMinimo()));
        addElement(String.valueOf(produto.getEstoqueMaximo()));
        addElement(String.valueOf(produto.getIdProduto()));
        addElement(produto.getNomeCategoria());
    }
}