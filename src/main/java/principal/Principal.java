package principal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
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
                    System.out.println("Nome: ");
                    String nome = input.next();
                    System.out.println("Preço unitário (R$): ");
                    Double preco = input.nextDouble();
                    System.out.println("Quantidade de produto: ");
                    int quantidadeP = input.nextInt();
                    System.out.println("Quantidade em estoque: ");
                    int quantidadeE = input.nextInt();
                    System.out.println("Quantidade mínima necessãria: ");
                    int quantidadeMin = input.nextInt();
                    System.out.println("Quantidade máxima aceita: ");
                    int quantidadeMax = input.nextInt();
                    System.out.println("Defina a categoria do produto: ");
                    String categoria = input.next();
                    System.out.println("Defina o Id (código de identificação) do produto: ");
                    int Id = input.nextInt();
                    break;
                case 2:
                    System.out.println("Defina o nome para a categoria: ");
                    String nomeC = input.next();
                    System.out.println("Determine o tamanho dos produtos pertencentes à categoria: ");
                    String tamanhoC = input.next();
                    System.out.println("Escolha o tipo de embalagem dos produtos da categoria ");
                    String embalagemC = input.next();
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

    }
}
