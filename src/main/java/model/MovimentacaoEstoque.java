package model;

public class MovimentacaoEstoque {

    private int data;
    private String tipoMovimentacao;
    private int quantidadeMovimentada;
    private String nomeProduto;

    public MovimentacaoEstoque(int quantidadeMovimentada, String nomeProduto) {
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.nomeProduto = nomeProduto;
    }

    public MovimentacaoEstoque() {
    }

    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}


