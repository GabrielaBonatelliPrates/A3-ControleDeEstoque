package model;

import java.util.Scanner;

public class Categoria {

    Scanner sc = new Scanner(System.in);

    //Declaração das variáveis de instância
    private String nome;
    private Tamanho tamanho;
    private Embalagem embalagem;
    
    public enum Embalagem{
        Plastico, Vidro, Metal;
    }
    
    public enum Tamanho{
        Pequeno, Medio, Grande;
    }

    //Construtor vazio
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(String nome, Tamanho tamanho, Embalagem embalagem) {
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

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
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
                this.tamanho = Tamanho.Pequeno;
                break;
            case 2:
                this.tamanho = Tamanho.Medio;
                break;
            case 3:
                this.tamanho = Tamanho.Grande;
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
                        this.embalagem = Embalagem.Vidro;
                        break;
                    case 2:
                        this.embalagem = Embalagem.Plastico;
                        break;
                    case 3:
                        this.embalagem = Embalagem.Metal;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
    }
}
