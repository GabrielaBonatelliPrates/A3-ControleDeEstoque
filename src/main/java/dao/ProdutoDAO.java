package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import dao.Conexao;
import model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

public class ProdutoDAO {

    protected static final List<Produto> produtos = new ArrayList<>(); //cria lista que vai armazenar os produtos

    public ProdutoDAO() {
    }

    public static void cadastrarProduto(String nomeProduto, double precoUnit, String unidadeProduto,
            int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo,
            String nomeCategoria, String tamanho, String embalagem) { //vai servir pra cadastrar produtos com quando a classe categoria tiver implementada certinho

        //método para colocar o produto no banco de dados
        inserirProduto(nomeProduto, precoUnit, unidadeProduto, quantidadeEstoque,
               estoqueMinimo, estoqueMaximo, nomeCategoria, tamanho, embalagem);
  }

    public static void inserirProduto(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, String nomeCategoria, String tamanho, String embalagem) {

        String sql = "INSERT INTO produtos (nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; //insere os dados na tabela

        try (
                Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
                 PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) //prepara o caminho para receber os dados e devolver a chave gerada
                ) {
            //preenche os parâmetros da query com os dados recebidos
            statement.setString(1, nomeProduto);
            statement.setDouble(2, precoUnit);
            statement.setString(3, unidadeProduto);
            statement.setInt(4, quantidadeEstoque);
            statement.setInt(5, estoqueMinimo);
            statement.setInt(6, estoqueMaximo);
            statement.setString(7, nomeCategoria);
            statement.setString(8, tamanho);
            statement.setString(9, embalagem);

            //executa a query para armazenar os dados
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys(); //devolve o id (gerado automaticamente pelo sql - posteriormente vamos substituir por um método (dicas do professor))
            if (resultSet.next()) {
                int idGerado = resultSet.getInt(1); //vai ler o id gerado
             //   insereLista(nomeProduto, idGerado, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo, estoqueMaximo, nomeCategoria); //adiciona o produto na lista
                String strIdGerado = String.format("Id do produto %s: %d", nomeProduto, idGerado);
                JOptionPane.showMessageDialog(null, strIdGerado); //exibe o id gerado pro usuário (já que era a informação que ele não entregou)
            }

        } catch (SQLException ex) { //trata erros de sql
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); //registra o erro no log
        }
    }
    
     public static List emiteLista() {
        return produtos; //retorna a lista 
    }

    public static ResultSet listarProdutos() { //método que retorna todos os produtos do banco
        String sql = "SELECT * FROM produtos"; //consulta sql que seleciona tudo da tabela produtos
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a consulta
            return statement.executeQuery(); //executa a consulta e retorna o resultado
        } catch (SQLException ex) { //em caso de erro
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); //log do erro
            return null; //retorna nulo se ocorrer falha
        }
    }
    
    public static DefaultTableModel tabelaAtualizada() throws SQLException{
        ResultSet resultSet = listarProdutos(); //todos os produtos do banco
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
    
    //carrega um produto pelo nome
    public static Produto buscarPorNome(String nomePesquisado) { //busca um produto específico no banco através do nome dele
        Connection connection = Conexao.conectar();
         Produto produto = null; //inicializa o objeto que será retornado
        Categoria categoria = null; //inicializa o objeto que será retornado

        String sql = "SELECT id, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos WHERE nome= ?"; //query para buscar produto pelo nome

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setString(1, nomePesquisado); //valor do nome é o parametro

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                produto = new Produto();
                categoria = new Categoria();
                produto.setIdProduto(resultSet.getInt("id"));
                produto.setNomeProduto(resultSet.getString("nome"));
                produto.setPrecoUnit(resultSet.getDouble("preco_unitario"));
                produto.setUnidadeProduto(resultSet.getString("unidade"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque_atual"));
                produto.setEstoqueMinimo(resultSet.getInt("estoque_minimo"));
                produto.setEstoqueMaximo(resultSet.getInt("estoque_maximo"));
                categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
                categoria.setTamanho(resultSet.getString("tamanho")); //vai definir o tamanho
                 categoria.setEmbalagem(resultSet.getString("embalagem")); //vai definir a embalagem
                 
                 produto.setCategoria(categoria);
            }

        } catch (SQLException erro) { //em caso de erro na consulta
            System.out.println("Erro: " + erro.getMessage()); //imprime mensagem de erro
        }

        return produto; //retorna o produto encontrado ou null
    }


    public boolean atualizarProduto(Produto produto, Categoria categoria) {
        String sql = "UPDATE produtos set nome = ? , preco_unitario = ? ,unidade = ? ,estoque_atual = ? ,estoque_minimo = ? ,estoque_maximo = ? , nome_categoria = ? ,tamanho = ? ,embalagem = ? WHERE id = ?";
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, produto.getNomeProduto());
            statement.setDouble(2, produto.getPrecoUnit());
            statement.setString(3, produto.getUnidadeProduto());
            statement.setInt(4, produto.getQuantidadeEstoque());
            statement.setInt(5, produto.getEstoqueMinimo());
            statement.setInt(6, produto.getEstoqueMaximo());
            statement.setString(7, categoria.getNomeCategoria());
            statement.setString(8, categoria.getTamanho());
            statement.setString(9, categoria.getEmbalagem());
            statement.setInt(10, produto.getIdProduto());

            statement.execute();
            statement.close();
            return true;
        } catch (SQLException erro) { //mostra erros de sql
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            return false;
        }
    }

    public boolean deletarProduto(int idProduto) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, idProduto);
            statement.executeUpdate();

            statement.close();
            return true;

        } catch (SQLException erro) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            return false;
        }
    }

    public static List <Produto> insereLista(String nomeProduto, int id, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, Categoria categoria) {
        Produto produto = new Produto(nomeProduto, id, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo, estoqueMaximo, categoria);
        produtos.add(produto); //adiciona o objeto criado à lista produtos 
        return produtos; //retorna a lista atualizada
    }

   

    //carrega um produto pelo id
    public static Produto buscarPorId(int idPesquisado) { //busca um produto específico no banco através do id
        Connection connection = Conexao.conectar();
        Produto produto = null; //inicializa o objeto que será retornado
        Categoria categoria = null; //inicializa o objeto que será retornado

        String sql = "SELECT id, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos WHERE id = ?"; //query para buscar produto por id

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setInt(1, idPesquisado); //define o valor do id como parâmetro da query

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                produto = new Produto();
                categoria = new Categoria();
                produto.setIdProduto(resultSet.getInt("id"));
                produto.setNomeProduto(resultSet.getString("nome"));
                produto.setPrecoUnit(resultSet.getDouble("preco_unitario"));
                produto.setUnidadeProduto(resultSet.getString("unidade"));
                produto.setQuantidadeEstoque(resultSet.getInt("estoque_atual"));
                produto.setEstoqueMinimo(resultSet.getInt("estoque_minimo"));
                produto.setEstoqueMaximo(resultSet.getInt("estoque_maximo"));
                categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
                categoria.setTamanho(resultSet.getString("tamanho")); //vai definir o tamanho
                 categoria.setEmbalagem(resultSet.getString("embalagem")); //vai definir a embalagem
                 
                 produto.setCategoria(categoria);
            }

        } catch (SQLException erro) { //em caso de erro na consulta
            System.out.println("Erro: " + erro.getMessage()); //imprime mensagem de erro
        }

        return produto; //retorna o produto encontrado ou null
    }

    //cria a ficha do produto
    public static String fichaProduto(String nomePesquisado) {
        Produto produtoPesquisado = buscarPorNome(nomePesquisado); //atribui o produto ao produto primeiro produto encontrado a partir do nome

        Categoria categoria = produtoPesquisado.getCategoria();
        String nomeCategoria = categoria.getNomeCategoria();
        String tamanho = categoria.getTamanho();
        String embalagem = categoria.getEmbalagem();
        //cria a string que vai enviar os dados
        String fichaProduto = String.format(
                "\n"
                + "Nome: %s\n"
                + "ID: %d\n"
                + "Preço unitário: R$ %.2f\n"
                + "Unidade de medida: %s\n"
                + "Estoque atual: %d unidades\n"
                + "Estoque mínimo: %d unidades\n"
                + "Estoque máximo: %d unidades\n"
                + "Categoria: %s\n"
                + "Tamanho: %s\n"
                + "Embalagem: %s\n",
                produtoPesquisado.getNomeProduto(),
                produtoPesquisado.getIdProduto(),
                produtoPesquisado.getPrecoUnit(),
                produtoPesquisado.getUnidadeProduto(),
                produtoPesquisado.getQuantidadeEstoque(),
                produtoPesquisado.getEstoqueMinimo(),
                produtoPesquisado.getEstoqueMaximo(),
                nomeCategoria,
                tamanho,
                embalagem
        );

        return fichaProduto; //retorna a ficha do produto
    }

    //verifica o status do estoque do produto
    public static String verificaProduto(String nomePesquisado) {
        Produto produtoPesquisado = buscarPorNome(nomePesquisado); //atribui o produto ao produto primeiro produto encontrado a partir do nome
        int estoqueAtual = produtoPesquisado.getQuantidadeEstoque();
        int estoqueMinimo = produtoPesquisado.getEstoqueMinimo();
        int estoqueMaximo = produtoPesquisado.getEstoqueMaximo();

        String statusProduto = "Status: ";

        if (estoqueAtual >= 0) {
            if (estoqueAtual >= estoqueMinimo && estoqueAtual <= estoqueMaximo) { //se o estoque atual for maior que o mínimo e menor que o máximo - está regular
                statusProduto += String.format("o estoque do produto \"%s\" está dentro do padrão esperado.\nReposição não é necessária no momento.\n", nomePesquisado);
            } else if (estoqueAtual < estoqueMinimo) { //se o estoque atual for menor que o mínimo - precisa de reposição
                statusProduto += String.format("o estoque do produto \"%s\" está abaixo do mínimo estabelecido.\nReposição é recomendada.\n", nomePesquisado);
            } else if (estoqueAtual > estoqueMaximo) { //se o estoque atual for maior que o máximo - não precisa de reposição
                statusProduto += String.format("o estoque do produto \"%s\" está acima do máximo permitido.\nNão é recomendada nova reposição.\n", nomePesquisado);
            }
        } else { //se o estoque atual for menor ou igual a zero ele não existe
            statusProduto += String.format("o estoque do produto \"%s\" não está registrado corretamente.\n", nomePesquisado);
        }

        return statusProduto; //retorna o status do produto
    }
    
    public static List<Produto> pegarProdutos() {
        
        String sql = "SELECT id, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos";
        
        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Produto objeto = new Produto();
                objeto.setIdProduto(resultSet.getInt("id"));
                objeto.setNomeProduto(resultSet.getString("nome"));
                objeto.setPrecoUnit(resultSet.getDouble("preco_unitario"));
                objeto.setUnidadeProduto(resultSet.getString("unidade"));
                objeto.setQuantidadeEstoque(resultSet.getInt("estoque_atual"));
                objeto.setEstoqueMinimo(resultSet.getInt("estoque_minimo"));
                objeto.setEstoqueMaximo(resultSet.getInt("estoque_maximo"));
                
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(resultSet.getString("nome_categoria"));
                categoria.setTamanho(resultSet.getString("tamanho"));
                categoria.setEmbalagem(resultSet.getString("embalagem"));
                objeto.setCategoria(categoria);


                
                produtos.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    
    public static List<Produto> pegarProdutosAcimaMaximo() {
        List<Produto> produtosAcima = new ArrayList<>();
        for(Produto a : produtos){
            if(a.getQuantidadeEstoque() >= a.getEstoqueMaximo()){
                produtosAcima.add(a);
            }
        }   
            return produtosAcima;
    }
    
    public static List<Produto> pegarProdutosAbaixoMinimo() {
        List<Produto> produtosAbaixo = new ArrayList<>();
        for(Produto a : produtos){
            if(a.getQuantidadeEstoque() <= a.getEstoqueMaximo()){
                produtosAbaixo.add(a);
            }
        }   
            return produtosAbaixo;
    }
}
