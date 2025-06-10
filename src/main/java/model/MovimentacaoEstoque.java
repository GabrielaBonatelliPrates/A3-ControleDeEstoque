package model;

import java.util.Date;

/**
 * classe MovimentacaoEstoque é uma classe para instanciar as movimentações
 *
 * @author Davi-Wolff
 */
public class MovimentacaoEstoque {

    /**
     * Declaração das variáveis de instância
     */
    private int idMovimentacao;         //id da movimentação
    private int idProduto;              //id do produto
    private String nomeProduto;         //nome do produto
    private int quantidadeMovimentada; //quantidade movimentada
    private String tipoMovimentacao;   //tipo: entrada ou saída
    private Date dataMovimentacao;     //data da movimentação

    /**
     * Construtor da classe Movimentacao
     */
    public MovimentacaoEstoque() {
    }

    //getters e setters
    /**
     *
     * @return id da movimentação
     */
    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    /**
     *
     * @param idMovimentacao atribui um id para a movimentação
     */
    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    /**
     *
     * @return id do produto para a movimentação
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     *
     * @param idProduto atribui um id do produto para a movimentação
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     *
     * @return nome do produto para a movimentação
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     *
     * @param nomeProduto atribui um nome do produto para a movimentação
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     *
     * @return quantidade da movimentação
     */
    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    /**
     *
     * @param quantidadeMovimentada atribui uma quantidade da movimentação
     */
    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    /**
     *
     * @return tipo para a movimentação
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    /**
     *
     * @param tipoMovimentacao atribui um tipo para a movimentação
     */
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    /**
     *
     * @return data para a movimentação
     */
    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     *
     * @param dataMovimentacao atribui uma data para a movimentação
     */
    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}
