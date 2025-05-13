package model;

import java.util.Scanner;

public class Produto {

    Scanner sc = new Scanner(System.in);

    //Declaração dos atributos privados da classe Produto
    private String nomeProduto;
    private double precoUnit;
    private int unidadeProduto;
    private int quantEstoque;
    private int quantMin;
    private int quantMax;
    private Categoria categoria;
    private int idProduto;

    public Produto() {
    }

    public Produto(String nomeProduto, double precoUnit, int unidadeProduto, int quantEstoque, int quantMin, int quantMax, Categoria categoria, int idProduto) {
        this.nomeProduto = nomeProduto;
        this.precoUnit = precoUnit;
        this.unidadeProduto = unidadeProduto;
        this.quantEstoque = quantEstoque;
        this.quantMin = quantMin;
        this.quantMax = quantMax;
        this.categoria = categoria;
        this.idProduto = idProduto;
    }

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

    public int getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(int unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public int getQuantMin() {
        return quantMin;
    }

    public void setQuantMin(int quantMin) {
        this.quantMin = quantMin;
    }

    public int getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(int quantMax) {
        this.quantMax = quantMax;
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

    public void setIdProduto() {
        this.idProduto = idProduto;
    }

    public void leituraProduto() {
        this.nomeProduto = sc.nextLine();
        this.precoUnit = sc.nextDouble();
        this.unidadeProduto = sc.nextInt();
        this.quantEstoque = sc.nextInt();
        this.quantMin = sc.nextInt();
        this.quantMax = sc.nextInt();
        //this.categoria = sc.nextLine();
        this.idProduto = sc.nextInt();

    }
}
