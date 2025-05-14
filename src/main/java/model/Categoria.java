package model;

import java.util.Scanner;

public class Categoria {

    Scanner sc = new Scanner(System.in);

    private String nome;
    private char tamanho;
    private String embalagem;

    public Categoria() {
    }

    public Categoria(String nome, char tamanho, String embalagem) {
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

    public void leituraCategoria() {
        
        
        this.nome = sc.nextLine(); //Pegando o nome

        //Pegando o tamanho
        System.out.print("Insira o tamanho (P/M/G)");
        char resposta = Character.toUpperCase(sc.next().charAt(0));
        if (resposta == 'P'){
            this.tamanho = 'P';
        }if (resposta == 'M'){
            this.tamanho = sc.next().charAt(0);
        } else {
            this.tamanho = sc.next().charAt(0);
        }
        
        //Pegando a embalagem
        System.out.print("Insira a embalagem (Vidro/Plastico/Metal)");
        String embalagens = sc.nextLine();
        if (embalagens == "Vidro"){
            this.embalagem = "Vidro";
        }if (embalagens == "Plastico"){
            this.embalagem = "Plastico";
        } else {
            this.embalagem = "Metal";
        }
        
        //Verifiquem se ta certo, caso estiver errado algo favor avisar e arrumar
    }
}
