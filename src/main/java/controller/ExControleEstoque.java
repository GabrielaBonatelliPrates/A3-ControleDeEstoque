package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import model.Produto;

public class ExControleEstoque {

    
    
    
    
    
    
    
    

    
    public boolean movimentacaoEstoqueReducao(int id, int atualizacao) {
        for (Produto x : produtos) {
            //Pegando o nome do Produto na Lista "produtos"
            int possivelId = x.getIdProduto();

            if (id == possivelId) {
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

    public boolean movimentacaoEstoqueAdicao(int id, int atualizacao) {
        for (Produto x : produtos) {
            //Pegando o nome do Produto na Lista "produtos"
            int possivelId = x.getIdProduto();

            if (id == possivelId) {
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

    

        /**
         * public void reajusteDePreco(double novoPreco) { //Tendo em vista que
         * terá um "consultarProduto" antes de ter um reajuste de preço
         *
         * Produto produto = new Produto();
         *
         * System.out.print("Insira a nova quantidade do produto"); //Pedindo o
         * novo preço novoPreco = input.nextDouble(); //Pegando o novo preço
         *
         * for (int i = 0; i < produtos.size(); i++) { if (i ==
         * consultaProduto()) { //Indo até o produto selecionado
         * produto.setPrecoUnit(novoPreco); //Alterando o preço } } }
         */
    }
}
