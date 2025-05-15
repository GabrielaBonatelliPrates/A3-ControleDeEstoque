package model;

import java.util.Scanner;

public class Produto {

    Scanner sc = new Scanner(System.in);

    //variaveis de intancia
    private String nomeProduto;
    private double precoUnit;
    private String unidadeProduto;
    private int quantidadeEstoque;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private int idProduto;
    private String nomeCategoria;

    //construtores
    public Produto() {
    }

    public Produto(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, String nomeCategoria, int idProduto) {
        this.nomeProduto = nomeProduto;
        this.precoUnit = precoUnit;
        this.unidadeProduto = unidadeProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.idProduto = idProduto;
        this.nomeCategoria = nomeCategoria;
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

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    //Método 1 que mostra se o estoque do produto está no mínimo
    public boolean estaNoEstoqueMin() {
        return this.quantidadeEstoque == this.estoqueMinimo;
    }
    //Método 2 que mostra se o estoque do produto está no máximo
    public boolean estaNoEstoqueMax() {
        return this.quantidadeEstoque == this.estoqueMaximo;
    }

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
        
        //Mostra a seguinte mensagem se estiver em baixo estoque:
        if (quantidadeEstoque < estoqueMinimo) {
            System.out.println("Estoque baixo!");
        } else if (quantidadeEstoque > estoqueMaximo) { //Mostra a seguinte mensagem se estiver em estoque máximo
            System.out.println("Estoque acima do limite!");
        } else {
            System.out.println("Estoque dentro do esperado."); //Mostra mensagem caso esteja dentro do estoque esperado
        }
        
        //Vou terminar ou trocar caso algo esteja faltando ou errado

    }

}
