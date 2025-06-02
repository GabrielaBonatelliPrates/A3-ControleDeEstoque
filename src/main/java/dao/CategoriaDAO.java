package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Categoria;

public class CategoriaDAO {

    protected static final List<Categoria> categorias = new ArrayList<>(); //cria lista que vai armazenar os produtos

    public CategoriaDAO() {
    }

    public void cadastrarCategoria(String nome, String tamanho, String embalagem) { //vai servir pra cadastrar a categoria

    }

    //método para colocar a categoria no banco de dados
    public static void inserirCategoria(String nome, String tamanho, String embalagem) throws SQLException {
        Categoria categoria = new Categoria ();
        String sql = "INSERT INTO categorias (nome, tamanho, embalagem) VALUES (?, ?, ?)"; //insere os dados na tabela

        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nome);
            statement.setString(2, tamanho);
            statement.setString(3, embalagem);

            //executa a query para armazenar os dados
            statement.executeUpdate();
        }
    }

    public static ResultSet listarCategorias() { //método que retorna todos as categorias do banco
        String sql = "SELECT * FROM categorias"; //consulta sql que seleciona tudo da tabela categorias
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a consulta
            return statement.executeQuery(); //executa a consulta e retorna o resultado
        } catch (SQLException ex) { //em caso de erro
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); //log do erro
            return null; //retorna nulo se ocorrer falha
        }
    }
    
       public ArrayList<String> mostrarCategorias() { //método que retorna os nomes das categorias do banco
           ArrayList<String> mostrarCategorias = new ArrayList();
        String sql = "SELECT nome FROM categorias"; //consulta sql que seleciona o nome da categoria na tabela categorias
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql); 
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                mostrarCategorias.add(resultSet.getString("nome")); //retorna o nome de todas as categorias que estão cadastradas no banco de dados
            }
            
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) { //em caso de erro
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); 
            return null; //retorna nulo caso dê erro
        }
        return mostrarCategorias;
       }


    public static DefaultTableModel tabelaAtualizada() throws SQLException {
        ResultSet resultSet = listarCategorias(); //todas as categorias do banco
        DefaultTableModel model = montarTabela(resultSet);
        return model;
    }

    public static DefaultTableModel montarTabela(ResultSet resultSet) throws SQLException { //constroi um modelo de tabela com base no ResultSet
        DefaultTableModel model = new DefaultTableModel(); //cria um novo modelo de tabela
        ResultSetMetaData metaData = resultSet.getMetaData(); //pega os metadados do resultado
        int columnCount = metaData.getColumnCount(); //conta o numero de colunas

        //adiciona os nomes das colunas
        for (int column = 1; column <= columnCount; column++) {
            model.addColumn(metaData.getColumnName(column));
        }

        //adiciona as linhas
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            model.addRow(row); //adiciona a linha ao modelo
        }

        return model; //retorna o modelo completo certinho
    }

    //carrega uma categoria pelo nome
    public static Categoria buscarPorNome(String nomePesquisado) { //busca uma categoria específica no banco através do nome dele
        Connection connection = Conexao.conectar();
        Categoria objeto = null; //inicializa o objeto que será retornado

        String sql = "SELECT nome, tamanho, embalagem FROM categorias WHERE nome= ?"; //query para buscar categoria pelo nome

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setString(1, nomePesquisado); //valor do nome é o parametro

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                objeto = new Categoria();
                objeto.setNomeCategoria(resultSet.getString("nome"));
                objeto.setTamanho(resultSet.getString("tamanho"));
                objeto.setEmbalagem(resultSet.getString("embalagem"));
            }

        } catch (SQLException erro) { //em caso de erro na consulta
            System.out.println("Erro: " + erro.getMessage()); //imprime mensagem de erro
        }

        return objeto; //retorna a categoria encontrada ou null
    }

    //cria a ficha da categoria
    public static String fichaCategoria(String nomePesquisado) {
        Categoria categoriaPesquisada = buscarPorNome(nomePesquisado); //atribui a categoria a primeira categoria encontrado a partir do nome

        //cria a string que vai enviar os dados
        String fichaCategoria = String.format(
                "\n"
                + "Categoria: %s\n"
                + "Tamanho: %s\n"
                + "Embalagem: %s\n",
                categoriaPesquisada.getNomeCategoria(),
                categoriaPesquisada.getTamanho(),
                categoriaPesquisada.getEmbalagem()
        );

        return fichaCategoria; //retorna a ficha do produto
    }

    //metodo pra verificar se a categoria ja existe antes de adicionar
    public static boolean verificaCategoria(String nome, String tamanho, String embalagem) throws SQLException {
        String sql = "SELECT 1 FROM categorias WHERE nome= ? AND tamanho = ? AND embalagem = ?"; //query para buscar se existe alguma categoria com esses atributos (se achar uma para)

        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nome);
            statement.setString(2, tamanho);
            statement.setString(3, embalagem);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    //criar metodo pra devolver o status da categoria
    
     public List<Categoria> devolveCategorias(String nome) {
        
        String sql = "SELECT nome, tamanho, embalagem FROM produtos WHERE id = nome";
        
        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Categoria objeto = new Categoria();
                objeto.setNomeCategoria(resultSet.getString("nome"));
                objeto.setTamanho(resultSet.getString("tamanho"));
                objeto.setEmbalagem(resultSet.getString("embalagem"));
                
                categorias.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }
     
}
