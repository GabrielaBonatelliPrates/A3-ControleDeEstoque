package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import model.Produto;

public class ControleEstoque {

    public List<Produto> produtos = new ArrayList<>();//cria lista que vai armazenar os produtos
    protected Scanner input = new Scanner(System.in); //cria scanner para a classe toda

    public void cadastraProduto(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, String nomeCategoria, int idProduto) { //metodo para cadastrar produto e adicionar ele na lista
        Produto produto = new Produto(); //instanciar a classe produto (cria um objeto "produto")
        produto.setNomeProduto(nomeProduto);
        produto.setPrecoUnit(precoUnit);
        produto.setUnidadeProduto(unidadeProduto);
        produto.setQuantidadeEstoque(quantidadeEstoque);
        produto.setEstoqueMinimo(estoqueMinimo);
        produto.setEstoqueMaximo(estoqueMaximo);
        produto.setIdProduto(idProduto);
       // produto.setNomeCategoria(nomeCategoria); //le os dados do produto
        produtos.add(produto); //adiciona o objeto criado à lista produtos
    }

    public boolean movimentacaoEstoqueReducao(String nomeProduto, int atualizacao) {
        for (int i = 0; i < produtos.size(); i++) {
                    
                    //Pegando o nome do Produto na Lista "produtos"
                    Produto x = produtos.get(i);
                    String y = x.getNomeProduto();

            if (nomeProduto.equalsIgnoreCase(y.trim())) {
                int novaQuantidade = x.getQuantidadeEstoque() + atualizacao;

                x.setQuantidadeEstoque(novaQuantidade);

                //Boolean para avisar se ta acima da média
                if (x.getQuantidadeEstoque() >= x.getEstoqueMaximo()) {
                    x.setAcimaMedia(true);
                } else {
                    x.setAcimaMedia(false);
                }
                return true;
            }
        }
        // Produto não encontrado
        return false;
    }

    public boolean movimentacaoEstoqueAdicao(String nomeProduto, int atualizacao) {
        for (int i = 0; i < produtos.size(); i++) {
                    
                    //Pegando o nome do Produto na Lista "produtos"
                    Produto x = produtos.get(i);
                    String y = x.getNomeProduto();

            if (nomeProduto.equalsIgnoreCase(y.trim())) {
                int novaQuantidade = x.getQuantidadeEstoque() + atualizacao;

                x.setQuantidadeEstoque(novaQuantidade);

                //Boolean para avisar se ta acima da média
                if (x.getQuantidadeEstoque() >= x.getEstoqueMaximo()) {
                    x.setAcimaMedia(true);
                } else {
                    x.setAcimaMedia(false);
                }
                return true;
            }
        }
        // Produto não encontrado
        return false;
    }

    public int tamanhoLista() {
        return produtos.size();
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
            String informacoes = String.format("Nome: %s\nID: %s\nPreço unitário: %s\nUnidade de medida: %s\nQuantidades em estoque: %s\nQuantidade mínima: %s\nQuantidade máxima: %s\n",
                    produtoPesquisado.getNomeProduto(),
                    produtoPesquisado.getIdProduto(),
                    produtoPesquisado.getPrecoUnit(),
                    produtoPesquisado.getUnidadeProduto(),
                    produtoPesquisado.getQuantidadeEstoque(),
                    produtoPesquisado.getEstoqueMinimo(),
                    produtoPesquisado.getEstoqueMaximo());
                    //produtoPesquisado.getNomeCategoria());
            System.out.println(informacoes);
        }
    }

    public void movimentacaoEstoque() { //metodo para chamar a classe MovimentacaoEstoque quando houver uma movimentacao
        MovimentacaoEstoque atualizacao = new MovimentacaoEstoque();
        atualizacao.atualizaEstoque();
    }

    public void relatorioEstoqueMinMax() {
        for (Produto p : produtos) {
            int quantidade = p.getQuantidadeEstoque();
            int minimo = p.getEstoqueMinimo();
            int maximo = p.getEstoqueMaximo();

            if (quantidade < minimo) {
                System.out.println("O produto " + p.getNomeProduto() + " está ABAIXO do estoque mínimo!");
                System.out.println("Quantidade mínima permitida: " + minimo);
                System.out.println("Quantidade em estoque: " + quantidade);
            } else if (quantidade > maximo) {
                System.out.println("O produto: " + p.getNomeProduto() + " está ACIMA do estoque máximo!");
                System.out.println("Quantidade máxima permitida: " + maximo);
                System.out.println("Quantidade em estoque: " + quantidade);

            }
        }
    }

    public void relatorioProdutoCategoria() { //metodo para gerar relatorio de produto por categoria
        if (produtos.isEmpty()) { //verifica se há produtos cadastados
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.print("Digite o nome da categoria que deseja pesquisar: "); //pede a categoria que o usuario deseja emitir o relatorio
        String categoriaDigitada = input.nextLine().trim();

        String nomeId = "";
        int contador = 0;
/**
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) { //procura por produtos que tem a categoria correspondente a que o usuario deseja
                if (p.getNomeCategoria().equalsIgnoreCase(categoriaDigitada.trim())) { //se for correspondente é adicionada à saída
                    nomeId += "ID: " + p.getIdProduto()
                            + " | Nome: " + p.getNomeProduto() + "\n";
                    contador++; //conta quantos produtos existem com a categoria correspondente
                }
            }
            if (contador > 0) { //se houver pelo menos algum produto com a categoria correspondente
                System.out.println("\nLista de Produtos da Categoria: " + categoriaDigitada);
                System.out.println(nomeId); //imprime todos os produtos da categoria
                System.out.println("Total de produtos distintos na categoria \"" + categoriaDigitada + "\": " + contador); //imprime o total de produtos distintos presentes na categoria
            } else { //se não houver nenhum produto com a categoria correspondente
                System.out.println("Nenhum produto encontrado na categoria \"" + categoriaDigitada + "\".");
            }
        } else { //se não houver produtos cadastrados na lista
            System.out.println("Nenhum produto cadastrado.");
        }
    }
    */
/**
    public void listaDePrecos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está sem produtos");
            return;
        }

        ArrayList<String> nomeProdutos = new ArrayList<>();
        for (Produto p : produtos) {
            nomeProdutos.add(p.getNomeProduto());
        }

        Collections.sort(nomeProdutos); //para organizar em ordem alfabética

        String listaDePrecos = "Lista de preços:\n";
        for (String nome : nomeProdutos) {
            for (Produto p : produtos) {
                if (p.getNomeProduto().equals(nome)) {
                    listaDePrecos += String.format("Nome: %s\nPreço: R$ %.2f \nUnidade de medida: %s\nCategoria: %s\n\n",
                            p.getNomeProduto(),
                            p.getPrecoUnit(),
                            p.getUnidadeProduto(),
                            p.getNomeCategoria());
                }
            }
        }
        

        System.out.println(listaDePrecos);
*/
    }
/**
    public void reajusteDePreco(double novoPreco) {             //Tendo em vista que terá um "consultarProduto" antes de ter um reajuste de preço

        Produto produto = new Produto();

        System.out.print("Insira a nova quantidade do produto"); //Pedindo o novo preço
        novoPreco = input.nextDouble();                          //Pegando o novo preço

        for (int i = 0; i < produtos.size(); i++) {
            if (i == consultaProduto()) {                        //Indo até o produto selecionado
                produto.setPrecoUnit(novoPreco);                 //Alterando o preço
            }
        }
    }
    */
}
