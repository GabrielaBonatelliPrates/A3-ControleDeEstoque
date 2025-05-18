package model;

import java.util.Scanner;

public class Categoria {

    Scanner sc = new Scanner(System.in);

    //Declaração das variáveis de instância
    private String nome;
    private char tamanho;
    private String embalagem;

    //Construtor vazio
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(String nome, char tamanho, String embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    //Pedir e armazenar dados nos atributos da classe
    public void lerDados() {

        System.out.print("Digite o nome da categoria: ");

        //Declarando o nome de categoria
        this.nome = sc.nextLine();

        // Declarando o tamanho da categoria
        System.out.println("Escolha o tamanho:");
        System.out.println("1 - Pequeno (P)");
        System.out.println("2 - Médio (M)");
        System.out.println("3 - Grande (G)");
        System.out.print("Digite o número correspondente ao tamanho: ");
        int opcaoTamanho = sc.nextInt();

        switch (opcaoTamanho) {
            case 1:
                this.tamanho = 'P';
                break;
            case 2:
                this.tamanho = 'M';
                break;
            case 3:
                this.tamanho = 'G';
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

                //Declarando o tipo de embalagem da categoria
                System.out.println("Escolha o tipo de embalagem:");
                System.out.println("1 - Vidro");
                System.out.println("2 - Plástico");
                System.out.println("3 - Metal");
                System.out.print("Digite o número correspondente à embalagem: ");
                int opcaoEmbalagem = sc.nextInt();

                switch (opcaoEmbalagem) {
                    case 1:
                        this.embalagem = "Vidro";
                        break;
                    case 2:
                        this.embalagem = "Plastico";
                        break;
                    case 3:
                        this.embalagem = "Metal";
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
    }
}
