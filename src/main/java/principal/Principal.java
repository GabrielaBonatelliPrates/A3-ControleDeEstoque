package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Produto;
import model.Relatorios;
import model.Categoria;
import view.FrmMenuPrincipal;
import view.JProdutoNovo;

public class Principal {

    private static final FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
    

    public static void main(String[] args) {
        menuPrincipal.setSize(1920, 1080);
        menuPrincipal.setExtendedState(FrmMenuPrincipal.MAXIMIZED_BOTH);
        menuPrincipal.setVisible(true);
        
        

        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("O quê você deseja fazer?");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Cadastrar categoria");
            System.out.println("3. Acessar relatórios");
            System.out.println("0. Sair");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    Produto produto = new Produto();
                    produto.lerDados();
                    break;
                case 2:
                    Categoria categoria = new Categoria();
                    categoria.lerDados();
                    break;
                case 3:
                    System.out.println("Escolha o tipo de relátorio a ser acessado: ");
                    System.out.println("1. Lista de preços");
                    System.out.println("2. Balanço financeiro");
                    System.out.println("3. Produtos por categoria");
                    System.out.println("4. Produtos abaixo da quantidade mínima");
                    System.out.println("5. Produtos acima da quantidade máxima");
                    System.out.println("0. Voltar");
                    int opcao1;
                    opcao1 = input.nextInt();
                    switch (opcao1) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Saindo...");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        Relatorios relatorio = new Relatorios();

        while (true) {
            System.out.println("\n=== SISTEMA DE GESTÃO DE PRODUTOS ===");
            System.out.print("Escolha uma opção: ");
            System.out.println("\n1. Adicionar novo produto");
            System.out.println("2. Exibir balanço financeiro");
            System.out.println("0. Sair");

            int opcao1 = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (opcao) {
                case 1:
                    // Criar novo produto
                    Produto novoProduto = new Produto();
                    novoProduto.lerDados();
                    produtos.add(novoProduto);

                    // Adicionar ao relatório
                    if (produtos.size() == 1) {
                        // Adicionar cabeçalho apenas na primeira vez
                        relatorio.adicionarCabecalho();
                    }
                    relatorio.adicionarProduto(novoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    Relatorios.gerarRelatorio(produtos);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
