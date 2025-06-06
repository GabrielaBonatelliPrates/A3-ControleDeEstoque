package dao;

import controller.MovimentacaoEstoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentacaoDAO {

    public static final List<MovimentacaoEstoque> movimentacoes = new ArrayList<>(); //cria lista que vai armazenar as movimentações
    protected static final List<MovimentacaoEstoque> listaAtualizada = new ArrayList<>();//cria lista que vai armazenar as movimentações a partir do banco de dados

    public MovimentacaoDAO() {
    }
//public void inserirMovimentacao(Date data, int quantidadeMovimentada, String nomeProduto, String tipoMovimentacao) throws SQLException {
    public static void inserirMovimentacao(int id, Date data, int quantidadeMovimentada, String nomeProduto, String tipoMovimentacao) throws SQLException {
        
        String sql = "INSERT INTO movimentacao (id, nome, tipo, quantidade, data) VALUES (?,?,?,?,?)"; //insere os dados na tabela
        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            
            statement.setInt(1, id);
            statement.setString(2, nomeProduto);
            statement.setString(3, tipoMovimentacao);
            statement.setInt(4, quantidadeMovimentada);
            statement.setDate(5, new java.sql.Date(data.getTime()));  //Troca do java.util.Date para java.sql.Date

            //executa a query para armazenar os dados
            statement.executeUpdate();
        }
    }

    public void cadastrarMovimentacao() {

    }
    
    public static List<MovimentacaoEstoque> pegarMovimentacoes() {
        listaAtualizada.clear();

        String sql = "SELECT id, nome, tipo, quantidade, data FROM movimentacao"; //caso queiram botar o "ORDER BY"

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                MovimentacaoEstoque objeto = new MovimentacaoEstoque();
                objeto.setId(resultSet.getInt("id"));
                objeto.setNomeProduto(resultSet.getString("nome"));
                objeto.setTipoMovimentacao(resultSet.getString("tipo"));
                objeto.setQuantidadeMovimentada(resultSet.getInt("quantidade"));
                objeto.setData(resultSet.getDate("data"));

                listaAtualizada.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAtualizada;
    }
    
    public void adicionarQuantidade(int idProduto, int quantidadeAdicionar) {
        String sql = "UPDATE produtos SET quantidade = quantidade + ? FROM produto WHERE id = ?";

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            stmt.setInt(1, quantidadeAdicionar); // quantidade a adicionar
            stmt.setInt(2, idProduto);           // id do produto

            //executa a query para armazenar os dados
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void retirarQuantidade(int idProduto, int quantidadeRetirada) {
        String sql = "UPDATE produtos SET quantidade = quantidade - ? FROM produto WHERE id = ?";

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            stmt.setInt(1, quantidadeRetirada); // quantidade a adicionar
            stmt.setInt(2, idProduto);           // id do produto

            //executa a query para armazenar os dados
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
