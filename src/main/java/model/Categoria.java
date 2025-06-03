package model;

import java.util.Scanner;

public class Categoria {

    Scanner sc = new Scanner(System.in);

    //Declaração das variáveis de instância
    private int idCategoria;
    private String nomeCategoria;
    private String tamanho;
    private String embalagem;

    //Construtor vazio
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(int idCategoria, String nomeCategoria, String tamanho, String embalagem) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

    //Getters e setters
     public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
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
    
    @Override
    public String toString() {
        return nomeCategoria + " / " + tamanho + " / " + embalagem;
    }

    //Pedir e armazenar dados nos atributos da classe
    public void lerDados() {

        //Declarando o nome de categoria
        System.out.print("Digite o nome da categoria: ");
        this.nomeCategoria = sc.nextLine();

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
