package model;

import dao.CategoriaDAO;
import java.util.Scanner;
import java.util.Random;

public class Categoria {

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

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

    public Categoria(String nomeCategoria, String tamanho, String embalagem) {
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
    
    //Método para deixar o Id aleatório
    public void randomId(String nomeCategoria) {
        CategoriaDAO catDao = new CategoriaDAO();

        //Um for que passa por todos os itens da Lista
        for (int i = 0; i < catDao.categorias.size(); i++) {
            
            //Pegando o nome da Categoria na Lista "categorias"
            Categoria x = catDao.categorias.get(i);
            
            if (nomeCategoria.equalsIgnoreCase(x.getNomeCategoria().trim())) {

                int novoIdCategoria;
                boolean idUnico;

                do {
                    novoIdCategoria = random.nextInt(9999); // de 0 até 9998
                    idUnico = true;

                    // Verifica se esse ID já existe na lista
                    for (int z = 0; z < catDao.categorias.size(); z++) {
                        Categoria a = catDao.categorias.get(z);
                        
                        if (a.getIdCategoria()== novoIdCategoria) {
                            idUnico = false;
                            break;
                        }
                    }
                } while (!idUnico);
                this.idCategoria = novoIdCategoria;
            }
        }
    }
}
