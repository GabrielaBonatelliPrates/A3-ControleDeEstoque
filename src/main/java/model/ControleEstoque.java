package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ControleEstoque {

    private final List<Produto> produtos = new ArrayList<>();//cria lista que vai armazenar os produtos
    private final Scanner input = new Scanner(System.in); //cria scanner para a classe toda

    public void cadastraProduto() { //metodo para cadastrar produto e adicionar ele na lista
        Produto produto = new Produto(); //instanciar a classe produto (cria um objeto "produto")
        produto.lerDados(); //le os dados do produto
        produtos.add(produto); //adiciona o objeto criado à lista produtos
    }
        public int consultaProduto() { //metodo para procurar o produto correspondente ao nome que o usuario digitar

        boolean encontrado = false;
        int posicao = -1;
        if (!produtos.isEmpty()) { //verifica se a lista está vazia
            System.out.println("Digite o nome do produto: ");
            String produtoBuscado = input.nextLine();

            for (int i = 0; i < produtos.size(); i++) { //roda a lista a procura do produto
                Produto produtoProcurado = produtos.get(i);
                if (produtoProcurado.getNomeProduto().equalsIgnoreCase(produtoBuscado.trim())) { //se o nome do produto da posição i for igual ao nome do produto que o usuário esta procurando
                    posicao = i;
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) { //se encontrar avisa que encontrou
                System.out.println("Produto encontrado!");
            } else if (!encontrado) { //se nao encontrar vai avisar que nao encontrou
                System.out.println("O produto \"" + produtoBuscado + "\" não foi encontrado.");
            }
        } else { //se a lista tiver vazia avisa que ainda nao tem produtos cadastrado
            System.out.println("Nenhum produto cadastrado.");
        }
        return posicao; //devolve a posição do produto consultado para os métodos que precisarem
    }

public void pesquisaProduto() {
   int posicao = consultaProduto();
   if (!produtos.isEmpty() && posicao != -1) { //se a lista não estiver vazia e o prodito tiver sido encontrado, então pega as informações dele
       Produto produtoPesquisado = produtos.get(posicao); // transforma o produto pesquisado naquele que foi buscado
       String informacoes = String.format("Nome: %s\nID: %s\nPreço unitário: %s\nUnidade de medida: %s\nQuantidades em estoque: %s\nQuantidade mínima: %s\nQuantidade máxima: %s\nCategoria: %s\n",
      produtoPesquisado.getNomeProduto(),
      produtoPesquisado.getIdProduto(), 
      produtoPesquisado.getPrecoUnit(), 
      produtoPesquisado.getUnidadeProduto(), 
      produtoPesquisado.getQuantEstoque(),
      produtoPesquisado.getQuantMin(),
      produtoPesquisado.getQuantMax(),
      produtoPesquisado.getCategoria());
       System.out.println(informacoes);
   }
}
        
}
