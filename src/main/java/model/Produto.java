package model;

import controller.ControleEstoque;
import java.util.Random;
import java.util.Scanner;

public class Produto {

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    //variaveis de intancia
    private String nomeProduto;
    private int idProduto;
    private double precoUnit;
    private String unidadeProduto;
    private int quantidadeEstoque;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private Categoria categoria;
    private boolean acimaMedia;
    private boolean abaixoMedia;

    //construtores
    public Produto() {
    }

    public Produto(String nomeProduto, int idProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, Categoria nomeCategoria) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.precoUnit = precoUnit;
        this.unidadeProduto = unidadeProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.categoria = categoria;
    }

    //getters e setters
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public boolean isAcimaMedia() {
        return acimaMedia;
    }

    public void setAcimaMedia(boolean acimaMedia) {
        this.acimaMedia = acimaMedia;
    }

    public boolean isAbaixoMedia() {
        return abaixoMedia;
    }

    public void setAbaixoMedia(boolean abaixoMedia) {
        this.abaixoMedia = abaixoMedia;
    }

    public void verificaMediaAcima() {
        if (getQuantidadeEstoque() >= getEstoqueMaximo()) {
            setAcimaMedia(true);
        } else {
            setAcimaMedia(false);
        }
    }

    public void verificaMediaAbaixo() {
        if (getQuantidadeEstoque() <= getEstoqueMinimo()) {
            setAbaixoMedia(true);
        } else {
            setAbaixoMedia(false);
        }
    }

    //Método para deixar o Id aleatório
    public void randomId(String nomeProduto) {
        ControleEstoque con = new ControleEstoque();

        //Um for que passa por todos os itens da Lista
        for (int i = 0; i < con.produtos.size(); i++) {
            
            //Pegando o nome do Produto na Lista "produtos"
            Produto x = con.produtos.get(i);
            
            if (nomeProduto.equalsIgnoreCase(x.getNomeProduto().trim())) {

                int novoIdProduto;
                boolean idUnico;

                do {
                    novoIdProduto = random.nextInt(9999); // de 0 até 9998
                    idUnico = true;

                    // Verifica se esse ID já existe na lista
                    for (int z = 0; z < con.produtos.size(); z++) {
                        Produto a = con.produtos.get(z);
                        
                        if (a.getIdProduto() == novoIdProduto) {
                            idUnico = false;
                            break;
                        }
                    }
                } while (!idUnico);
                this.idProduto = novoIdProduto;
            }
        }
    }
/*
    //le os dados dos produtos
    public void lerDados() {

        System.out.print("Digite o ID do produto: ");
        this.idProduto = sc.nextInt();

        sc.nextLine(); //limpa a linha

        System.out.print("Digite o nome do produto: ");
        this.nomeProduto = sc.nextLine();

        System.out.print("Digite o preço unitário do produto: ");
        this.precoUnit = sc.nextDouble();

        sc.nextLine(); //limpa a linha

        System.out.print("Digite a unidade do produto: ");
        this.unidadeProduto = sc.nextLine();

        System.out.print("Digite a quantidade em estoque: ");
        this.quantidadeEstoque = sc.nextInt();

        System.out.print("Digite a quantidade mínima permitida em estoque: ");
        this.estoqueMinimo = sc.nextInt();

        System.out.print("Digite a quantidade máxima permitida em estoque: ");
        this.estoqueMaximo = sc.nextInt();

        sc.nextLine(); //limpa a linha

        Categoria cat = new Categoria();
        cat.lerDados();
        setNomeCategoria(cat.getNome());

    }
*/
}
