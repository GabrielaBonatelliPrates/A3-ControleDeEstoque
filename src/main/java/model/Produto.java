package model;

public class Produto {



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
    private double valorTotal = precoUnit * quantidadeEstoque;
    private double estoqueTotal;


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

    public Produto(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, Categoria categoria) {
        this.nomeProduto = nomeProduto;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getEstoqueTotal() {
        return estoqueTotal;
    }

    public void setEstoqueTotal(double estoqueTotal) {
        this.estoqueTotal += valorTotal;
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

}