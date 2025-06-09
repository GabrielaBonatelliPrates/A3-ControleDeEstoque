package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovimentacaoEstoque;

public class MovimentacaoDAO {

    public List<MovimentacaoEstoque> movimentacoes = new ArrayList<>();
    protected List<MovimentacaoEstoque> listaAtualizada = new ArrayList<>();
    private ProdutoDAO produtoDAO;

    public MovimentacaoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void cadastraMovimentacao(MovimentacaoEstoque movimentacao) {
        int idProduto = movimentacao.getIdProduto();
        Date data = movimentacao.getDataMovimentacao();
        int quantidadeMovimentada = movimentacao.getQuantidadeMovimentada();
        String nomeProduto = movimentacao.getNomeProduto();
        String tipoMovimentacao = movimentacao.getTipoMovimentacao();

        //atualiza o estoque com base no tipo de movimentação
        if (tipoMovimentacao.equalsIgnoreCase("entrada")) {
            adicionarQuantidade(idProduto, quantidadeMovimentada);
        } else if (tipoMovimentacao.equalsIgnoreCase("saida")) {
            retirarQuantidade(idProduto, quantidadeMovimentada);
        }

        try {
            inserirMovimentacao(idProduto, data, quantidadeMovimentada, nomeProduto, tipoMovimentacao);
        } catch (SQLException ex) {
            Logger.getLogger(MovimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //add movimentacao
    public void inserirMovimentacao(int idProduto, Date data, int quantidadeMovimentada, String nomeProduto, String tipoMovimentacao) throws SQLException {
        try (Connection connection = Conexao.conectar()) {
            String sql = "INSERT INTO movimentacao_estoque (tipoMovimentacao, idProduto, nomeProduto, quantidadeMovimentada, dataMovimentacao) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tipoMovimentacao);
            stmt.setInt(2, idProduto);
            stmt.setString(3, nomeProduto);
            stmt.setInt(4, quantidadeMovimentada);
            stmt.setDate(5, new java.sql.Date(data.getTime())); //coloca a data ?
            stmt.executeUpdate();
        }
    }

    //pra retornar a lista de movimentações da tabela movimentacao
    public List<MovimentacaoEstoque> listarProdutosMovimentados() {
        List<MovimentacaoEstoque> lista = new ArrayList<>();

        String sql = "SELECT * FROM movimentacao_estoque";

        try (
                Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MovimentacaoEstoque mov = new MovimentacaoEstoque();
                mov.setIdMovimentacao(rs.getInt("idMovimentacao"));
                mov.setTipoMovimentacao(rs.getString("tipoMovimentacao"));
                mov.setIdProduto(rs.getInt("idProduto"));
                mov.setNomeProduto(rs.getString("nomeProduto"));
                mov.setQuantidadeMovimentada(rs.getInt("quantidadeMovimentada"));
                mov.setDataMovimentacao(rs.getDate("dataMovimentacao"));
                lista.add(mov);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //metodo p adicionar ao estoque usando ProdutoDAO
    public void adicionarQuantidade(int idProduto, int quantidadeAdicionar) {
        produtoDAO.adicionarQuantidade(idProduto, quantidadeAdicionar); // repassa a chamada
    }

    //metodo p retirar do estoque usando ProdutoDAO
    public void retirarQuantidade(int idProduto, int quantidadeRetirar) {
        produtoDAO.retirarQuantidade(idProduto, quantidadeRetirar); // repassa a chamada
    }
}
