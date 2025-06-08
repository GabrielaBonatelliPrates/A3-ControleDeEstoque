package controller;

import dao.MovimentacaoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import model.Produto;

public class MovimentacaoEstoque extends ExControleEstoque {

    Random random = new Random();

    private Integer id;
    private Date data; //se possivel implementar a data
    private String tipoMovimentacao;
    private int quantidadeMovimentada;
    private String nomeProduto;
    public List<MovimentacaoEstoque> movimentacoes = new ArrayList<>(); //Cria uma lista para armazenar as moviemntações

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void verificarId() {
        List<MovimentacaoEstoque> movimentacoes = MovimentacaoDAO.pegarMovimentacoes();
        Random random = new Random();
        
        for(MovimentacaoEstoque movimento : movimentacoes){
            if(movimento.getId() == null){
                movimento.setId(random.nextInt(9999));
            }
        } 
    }

    //Método para deixar o Id aleatório
    public int gerarIdUnico() {
        List<MovimentacaoEstoque> movimentacoes = MovimentacaoDAO.pegarMovimentacoes();
        Random random = new Random();
        int novoId;

        boolean idExiste;
        do {
            novoId = random.nextInt(9999); // de 0 a 9998
            idExiste = false;

            for (MovimentacaoEstoque movimentacao : movimentacoes) {
                if (movimentacao.getId() == novoId) {
                    idExiste = true;
                    break;
                }
            }

        } while (idExiste); // repete até encontrar um ID que não exista

        return novoId;
    }

   
}
