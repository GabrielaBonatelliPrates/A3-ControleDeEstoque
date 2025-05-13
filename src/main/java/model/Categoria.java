package model;

import java.util.Scanner;

public class Categoria {
    
    Scanner sc = new Scanner(System.in);
    
    private String nome;
    private String tamanho;
    private String embalagem;

    public Categoria() {
    }

    public Categoria(String nome, String tamanho, String embalagem) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }

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
    
    public void leituraCategoria(){
        this.nome = sc.nextLine();
        this.tamanho = sc.nextLine();
        this.embalagem = sc.nextLine();
        
        //Dai a gnt troca 
    }
}
