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

/**CategoriaDAO é uma classe que faz a ligação de Categoria com o banco de dados
 *
 * @author laispaivaportela
 */
public class CategoriaDAO {

    /**
     * Cria lista que vai armazenar os produtos
     */
    public static final List<Categoria> categorias = new ArrayList<>(); 

    /**
     * Lista criada para armazenar novas categorias a partir do banco de dados.
     * @author Estermrn
     */
    public static final List<Categoria> listaAtualizada = new ArrayList<>();

    /** @param cadastrarCategoria para cadastrar uma nova categoria
     *
     * @param idCategoria atributo requerido para atribuir o id a uma categoria
     * @param nomeCategoria atributo requerido para atribuir o nome a uma categoria
     * @param tamanho atributo requerido para atribuir o tamanho a uma categoria
     * @param embalagem atributo requerido para atribuir a embalagem de uma categoria
     * @throws SQLException detecta erros de conexão com SQL
     */
    public void cadastrarCategoria(int idCategoria, String nomeCategoria, String tamanho, String embalagem) throws SQLException { //vai servir pra cadastrar a categoria
        inserirCategoria(idCategoria, nomeCategoria, tamanho, embalagem);
    }


    /** @param inserirCategoria para colocar a nova categoria no banco de dados
     *
     * @param idCategoria atributo requerido para atribuir o id a uma categoria no banco de dados
     * @param nomeCategoria atributo requerido para atribuir o nome a uma categoria no banco de dados
     * @param tamanho atributo requerido para atribuir o tamanho a uma categoria no banco de dados
     * @param embalagem atributo requerido para atribuir a embalagem de uma categoria no banco de dados
     * @throws SQLException detecta erros de conexão com SQL
     */
    public void inserirCategoria(int idCategoria, String nomeCategoria, String tamanho, String embalagem) throws SQLException {
        Categoria categoria = new Categoria();
        String sql = "INSERT INTO categorias (nomeCategoria, tamanho, embalagem) VALUES (?, ?, ?)"; //insere os dados na tabela

        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nomeCategoria);
            statement.setString(2, tamanho);
            statement.setString(3, embalagem);

            //executa a query para armazenar os dados
            statement.executeUpdate();
        }
    }

    /** lista as categorias
     *
     * @return statement.executeQuery executa a consulta e retorna a lista de categorias
     */
    public ResultSet listarCategorias() { //método que retorna todos as categorias do banco
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

    /**
     *
     * @return mostrarCategorias método que retorna os dados das categorias
     */
    public List<Categoria> mostrarCategorias() { //método que retorna os nomes das categorias do banco
        List<Categoria> mostrarCategorias = new ArrayList();
        String sql = "SELECT * FROM categorias"; //consulta sql que seleciona o nome da categoria na tabela categorias
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idCategoria = resultSet.getInt("idCategoria");
                String nomeCategoria = resultSet.getString("nomeCategoria");
                String tamanho = resultSet.getString("tamanho");
                String embalagem = resultSet.getString("embalagem");

                mostrarCategorias.add(new Categoria(idCategoria, nomeCategoria, tamanho, embalagem)); //retorna os dados de todas as categorias que estão cadastradas no banco de dados
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) { //em caso de erro
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mostrarCategorias;
    }

    /**
     *
     * @return odel retorna um novo modelo de tabela
     * @throws SQLException detecta erros de conexão com o banco SQL
     */
    public DefaultTableModel tabelaAtualizada() throws SQLException {
        ResultSet resultSet = listarCategorias(); //todas as categorias do banco
        DefaultTableModel model = montarTabela(resultSet);
        return model;
    }

    /**
     *
     * @param resultSet serve como base para construir um modelo de tabela
     * @return model retorna um novo modelo de tabela
     * @throws SQLException detecta erros de conexão com o banco SQL
     */
    public DefaultTableModel montarTabela(ResultSet resultSet) throws SQLException { //constroi um modelo de tabela com base no ResultSet
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
    
    /** método que busca categoria pelo id
     *
     * @param idCategoria parametro necessario para buscar uma categoria pelo id
     * @return retorna a categoria buscada
     */
    public Categoria buscarCategoriaPorId(int idCategoria) {
        String sql = "SELECT nomeCategoria, tamanho, embalagem FROM categorias WHERE idCategoria = ?";
        Categoria categoria = null;
        
        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, idCategoria);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(idCategoria);
                categoria.setNomeCategoria(resultSet.getString("nomeCategoria"));
                categoria.setTamanho(resultSet.getString("tamanho"));
                categoria.setEmbalagem(resultSet.getString("embalagem"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categoria;
    }

    /** metodo que busca um produto pelo nome 
     * 
     * @param nomePesquisado parametro para funcionamento correto do metodo
     * @return retorna a categoria pesquisada
     */
    public Categoria buscarPorNome(String nomePesquisado) { //busca uma categoria específica no banco através do nome dele
        Connection connection = Conexao.conectar();
        Categoria objeto = null; //inicializa o objeto que será retornado

        String sql = "SELECT idCategoria, nomeCategoria, tamanho, embalagem FROM categorias WHERE nomeCategoria= ?"; //query para buscar categoria pelo nome

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setString(1, nomePesquisado); //valor do nome é o parametro

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                objeto = new Categoria();
                objeto.setNomeCategoria(resultSet.getString("nomeCategoria"));
                objeto.setTamanho(resultSet.getString("tamanho"));
                objeto.setEmbalagem(resultSet.getString("embalagem"));
            }

        } catch (SQLException erro) { //em caso de erro na consulta
            System.out.println("Erro: " + erro.getMessage()); //imprime mensagem de erro
        }

        return objeto; //retorna a categoria encontrada ou null
    }
  
    /**
     * Atualiza os dados de uma categoria no banco de dados.
     * 
     * @author Estermrn
     * @param nomeCategoria novo nome da categoria.
     * @param tamanho novo tamanho da categoria.
     * @param embalagem nova embalagem da categoria.
     * @param idCategoria o identificador da categoria que será atualizada.
     * @return true se a atualização foi feita, false caso contrário.
     */
    public boolean atualizarCategoria(String nomeCategoria, String tamanho, String embalagem, int idCategoria) {
        String sql = "UPDATE categorias set nomeCategoria = ? , tamanho = ? , embalagem = ? WHERE idCategoria = ?";
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nomeCategoria);
            statement.setString(2, tamanho);
            statement.setString(3, embalagem);
            statement.setInt(4, idCategoria);

            statement.execute();
            statement.close();
            return true;

        } catch (SQLException erro) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            return false;
        }
    }

    /** Deleta uma categoria do banco de dados com base no ID.
     *
     * @author Estermrn
     * @param idCategoria identificador da categoria que será deletada.
     * @return true caso a categoria seja deletada, false caso contrário.
     */
    public boolean deletarCategoria(int idCategoria) {

        String sql = "DELETE FROM categorias WHERE idCategoria = ?";
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, idCategoria);
            statement.executeUpdate();

            statement.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    /** cria a ficha da categoria
     * 
     * @param nomePesquisado parametro necessario para mostrar a ficha de uma categoria quando este é pesquisado
     * @return retorna a categoria e todas as suas atribuições
     */
    public String fichaCategoria(String nomePesquisado) {
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
    
    /** busca ID da categoria
     * 
     * @param categoria parametro necessario para buscar o id de uma categoria
     * @return retorna o que foi encontrado com a pesquisa
     */
    public int buscarIdCategoria(Categoria categoria) {
        String sql = "SELECT idCategoria FROM categorias WHERE nomeCategoria = ? "
                + "AND tamanho = ? AND embalagem = ?";

        try (Connection connection = Conexao.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, categoria.getNomeCategoria());
            statement.setString(2, categoria.getTamanho());
            statement.setString(3, categoria.getEmbalagem());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idCategoria");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }



    /** busca a categoria completa
     *
     * @param nomeCategoria parâmetro necessário para buscar os dados da categoria
     * @param tamanho parâmetro necessário para buscar os dados da categoria
     * @param embalagem parâmetro necessário para buscar os dados da categoria
     * @return retorna os dados da categoria procurada
     */
    public Categoria buscarCategoria(String nomeCategoria, String tamanho, String embalagem) {
        String sql = "SELECT idCategoria, nomeCategoria, tamanho, embalagem FROM categorias "
                + "WHERE nomeCategoria = ? AND tamanho = ? AND embalagem = ?";

        try (Connection connection = Conexao.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nomeCategoria);
            statement.setString(2, tamanho);
            statement.setString(3, embalagem);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNomeCategoria(rs.getString("nomeCategoria"));
                categoria.setTamanho(rs.getString("tamanho"));
                categoria.setEmbalagem(rs.getString("embalagem"));
                return categoria;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /** Metodo pra verificar se a categoria ja existe antes de adicionar
     *
     * @param nomeCategoria atributo necessário para execução do método
     * @param tamanho atributo necessário para execução do método
     * @param embalagem atributo necessário para execução do método
     * @return retorna se a categoria já existe ou não
     * @throws SQLException detecta erros de conexão com o banco SQL
     */
    public boolean verificaCategoria(String nomeCategoria, String tamanho, String embalagem) throws SQLException {
        String sql = "SELECT 1 FROM categorias WHERE nomeCategoria= ? AND tamanho = ? AND embalagem = ?"; //query para buscar se existe alguma categoria com esses atributos (se achar uma para)

        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nomeCategoria);
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

    /**
     * Pega todas as categorias cadastradas no banco de dados e retorna uma lista atualizada.
     * 
     * @author Estermrn
     * @return lista atualizada com todas as categorias encontradas no banco de dados.
     */
    public List<Categoria> pegarCategorias() {
        listaAtualizada.clear();

        String sql = "SELECT idCategoria, nomeCategoria, tamanho, embalagem FROM categorias";
        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(resultSet.getString("nomeCategoria"));
                categoria.setTamanho(resultSet.getString("tamanho"));
                categoria.setEmbalagem(resultSet.getString("embalagem"));

                listaAtualizada.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAtualizada;
    }

    /**
     *
     * @param nomeCategoria necessário para buscar as categorias
     * @return retorna a lista das categorias
     */
    public List<Categoria> devolveCategorias(String nomeCategoria) {

        String sql = "SELECT idCategoria, nomeCategoria, tamanho, embalagem FROM produtos WHERE idCategoria = nomeCategoria";

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Categoria objeto = new Categoria();
                objeto.setIdCategoria(resultSet.getInt("idCategoria"));
                objeto.setNomeCategoria(resultSet.getString("nomeCategoria"));
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
