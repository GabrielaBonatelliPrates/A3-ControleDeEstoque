package dao;

import controller.MovimentacaoEstoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimentacaoDAO {

    public static final List<MovimentacaoEstoque> movimentacoes = new ArrayList<>(); //cria lista que vai armazenar as movimentações

    public MovimentacaoDAO() {
    }

    public void inserirMovimentacao(Date data, int quantidadeMovimentada, String nomeProduto, String tipoMovimentacao) throws SQLException {
        
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        
        String sql = "INSERT INTO movimentacao (nome, tipo, quantidade, data) VALUES (?, ?, ?, ?)"; //insere os dados na tabela
        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nomeProduto);
            statement.setString(2, tipoMovimentacao);
            statement.setInt(3, quantidadeMovimentada);
            statement.setDate(4, (java.sql.Date) data);

            //executa a query para armazenar os dados
            statement.executeUpdate();
        }
    }

    public void cadastrarMovimentacao() {

    }

}
