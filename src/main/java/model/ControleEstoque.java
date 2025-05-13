package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ControleEstoque {

    private final List<Produto> produtos = new ArrayList<>();//cria lista que vai armazenar os produtos
    private final Scanner input = new Scanner(System.in); //cria scanner para a classe toda

    public void cadastraProduto() {
        Produto produto = new Produto(); //instanciar a classe produto (cria um objeto "produto")
        produto.lerDados();
        produtos.add(produto);
    }
}
