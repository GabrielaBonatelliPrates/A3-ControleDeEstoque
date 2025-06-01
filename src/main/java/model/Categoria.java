package model;

import java.util.Scanner;

public class Categoria {

    Scanner sc = new Scanner(System.in);

    //Declaração das variáveis de instância
    private String nome;
    private String tamanho;
    private String embalagem;

    //Construtor vazio
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(String nome, String tamanho, String embalagem) {
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
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

        //Declarando o nome de categoria
        System.out.print("Digite o nome da categoria: ");
        this.nome = sc.nextLine();

        sc.nextLine();

        // Declarando o tamanho da categoria
        System.out.println("Digite o tamanho:");
        this.tamanho = sc.nextLine();

        sc.nextLine();

        //Declarando o tipo de embalagem da categoria
        System.out.println("Digite o tipo de embalagem:");

        sc.nextLine();//Limpa a linha

    }
}
