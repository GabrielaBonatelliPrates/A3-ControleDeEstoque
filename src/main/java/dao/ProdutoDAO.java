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
import model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

/**ProdutoDAO é uma classe que implementa um novo produto ao banco de dados
 *
 * @author laispaivaportela
 */
public class ProdutoDAO {

    /**
     *declaração e instancia de atributos
     */
    protected CategoriaDAO categoriaDAO;
    protected List<Produto> produtos = new ArrayList<>(); //cria lista que vai armazenar os produtos da sessão (caso haja algum problema no banco de dados)
    protected List<Produto> listaAtualizada = new ArrayList<>(); //cria lista que vai armazenar os produtos a partir do banco de dados

    /**
     *
     * @param categoriaDAO valor inicial de categoriaDAO
     */
    public ProdutoDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    /**Metodo para cadastrar novo produto 
     *
     * @param nomeProduto atributo requerido para atribuir o nome a um produto
     * @param precoUnit atributo requerido para atribuir o preço unitario a um produto
     * @param unidadeProduto atributo requerido para atribuir uma unidade de medida a um produto
     * @param quantidadeEstoque atributo requerido para atribuir a quantidade em estoque a um produto
     * @param estoqueMinimo atributo requerido para atribuir a quantidade em estoque minima a um produto
     * @param estoqueMaximo atributo requerido para atribuir a quantidade em estoque maxima a um produto
     * @param nomeCategoria atributo requerido para atribuir o nome de uma categoria a um produto
     * @param tamanho atributo requerido para atribuir o tamanho de uma categoria a um produto
     * @param embalagem atributo requerido para atribuir a embalagem de uma categoria a um produto
     */
    public void cadastrarProduto(String nomeProduto, double precoUnit, String unidadeProduto,
            int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo,
            String nomeCategoria, String tamanho, String embalagem) { //vai servir pra cadastrar produtos com quando a classe categoria tiver implementada certinho

        //método para colocar o produto no banco de dados
        inserirProduto(nomeProduto, precoUnit, unidadeProduto, quantidadeEstoque,
                estoqueMinimo, estoqueMaximo, nomeCategoria, tamanho, embalagem);
    }

    /**
     * Metodo para inserir novo produto ao banco de dados
     * 
     * @param nomeProduto atributo requerido para atribuir o nome a um produto no banco de dados
     * @param precoUnit atributo requerido para atribuir o preço unitario a um produto no banco de dados
     * @param unidadeProduto atributo requerido para atribuir uma unidade de medida a um produto no banco de dados
     * @param quantidadeEstoque atributo requerido para atribuir a quantidade em estoque a um produto no banco de dados
     * @param estoqueMinimo atributo requerido para atribuir a quantidade em estoque minima a um produto no banco de dados
     * @param estoqueMaximo atributo requerido para atribuir a quantidade em estoque maxima a um produto no banco de dados
     * @param nomeCategoria atributo requerido para atribuir o nome de uma categoria a um produto no banco de dados
     * @param tamanho atributo requerido para atribuir o tamanho de uma categoria a um produto no banco de dados
     * @param embalagem atributo requerido para atribuir a embalagem de uma categoria a um produto no banco de dados
     */
    public void inserirProduto(String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, String nomeCategoria, String tamanho, String embalagem) {

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

                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(nomeCategoria);
                categoria.setTamanho(tamanho);
                categoria.setEmbalagem(embalagem);

                insereLista(nomeProduto, idGerado, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo, estoqueMaximo, categoria); //adiciona o produto na lista
                String strIdGerado = String.format("Id do produto %s: %d", nomeProduto, idGerado);
                JOptionPane.showMessageDialog(null, strIdGerado); //exibe o id gerado pro usuário (já que era a informação que ele não entregou)
            }

        } catch (SQLException ex) { //trata erros de sql
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); //registra o erro no log
        }
    }

    /**
     *
     * @return produtos retorna uma lista de produtos
     */
    public List emiteLista() {
        return produtos; //retorna a lista 
    }

    /**
     *
     * @return statement.executeQuery() executa a consulta e retorna a lista de produtos
     */
    public ResultSet listarProdutos() { //método que retorna todos os produtos do banco
        String sql = "SELECT * FROM produtos"; //consulta sql que seleciona tudo da tabela produtos
        try {
            Connection connection = Conexao.conectar();
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a consulta
            return statement.executeQuery();
        } catch (SQLException ex) { //em caso de erro
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex); //log do erro
            return null; //retorna nulo se ocorrer falha
        }
    }

    /**
     *
     * @throws SQLException detecta erros de conexão com o banco SQL
     */
    public DefaultTableModel tabelaAtualizada() throws SQLException {
        ResultSet resultSet = listarProdutos(); //todos os produtos do banco
        DefaultTableModel model = montarTabela(resultSet);
        return model;
    }

    /**
     *
     * @param resultSet serve como base para construir um modelo de tabela
     * @return model retorna um novo modelo de tabela
     * @throws SQLException detecta erros de conexão com SQL
     */
    public DefaultTableModel montarTabela(ResultSet resultSet) throws SQLException { //constroi um modelo de tabela com base no ResultSet
        DefaultTableModel model = new DefaultTableModel();
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
    
    /** Método para carregar um produto pelo nome
     *
     * @param buscarPorNome metodo que busca um produto pelo nome 
     * @param nomePesquisado parametro para funcionamento correto do metodo
     * @return produto retorna o produto pesquisado
     */
    public Produto buscarPorNome(String nomePesquisado) { //busca um produto específico no banco através do nome dele
        Connection connection = Conexao.conectar();
        Produto produto = null; //inicializa o objeto que será retornado
        Categoria categoria = null; //inicializa o objeto que será retornado

        String sql = "SELECT idProduto, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos WHERE nome= ?"; //query para buscar produto pelo nome

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setString(1, nomePesquisado); //valor do nome é o parametro

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                produto = new Produto();
                categoria = new Categoria();
                produto.setIdProduto(resultSet.getInt("idProduto"));
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

    /** Método para atualizar produto no banco de dados
     * 
     * @author GabrielaBonatelliPrates
     * @param produto parametro para atualizar um objeto instanciado do tipo produto
     * @param categoria parametro para atualizar um objeto instanciado do tipo categoria
     */
    public boolean atualizarProduto(Produto produto, Categoria categoria) {
        String sql = "UPDATE produtos set nome = ? , preco_unitario = ? ,unidade = ? ,estoque_atual = ? ,estoque_minimo = ? ,estoque_maximo = ? , nome_categoria = ? ,tamanho = ? ,embalagem = ? WHERE idProduto = ?";
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

    /** Método para atualizar produto
     * @author GabrielaBonatelliPrates
     * @param atualizarProdutoBD metodo para atualizar produto do banco de dados
     * @param nomeProduto atributo requerido para atualizar o nome de um produto no banco de dados
     * @param precoUnit atributo requerido para atualizar o preço unitario de um produto no banco de dados
     * @param unidadeProduto atributo requerido para atualizar a unidade de medida de um produto no banco de dados
     * @param quantidadeEstoque atributo requerido para atualizar a quantidade em estoque de um produto no banco de dados
     * @param estoqueMinimo atributo requerido para atualizar a quantidade minima em estoque de um produto no banco de dados
     * @param estoqueMaximo atributo requerido para atualizar a quantidade maxima em estoque de um produto no banco de dados
     * @param nomeCategoria atributo requerido para atualizar o nome da categoria de um produto no banco de dados
     * @param tamanho atributo requerido para atualizar o tamanho de um produto no banco de dados
     * @param embalagem atributo requerido para atualizar a embalagem de um produto no banco de dados
     * @return retorna a atualização do produto efetivamente 
     */
    public boolean atualizarProdutoBD(int idProduto, String nomeProduto, double precoUnit, String unidadeProduto, int quantidadeEstoque,
            int estoqueMinimo, int estoqueMaximo, String nomeCategoria, String tamanho, String embalagem) {
        Categoria categoria = new Categoria(nomeCategoria, tamanho, embalagem);

        Produto produto = new Produto(nomeProduto, idProduto, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo,
                estoqueMaximo, categoria);
        atualizarProduto(produto, categoria);
        return true;
    }

    /** Método que atualiza o preço de um produto no banco de dados
     * @param nome atributo requerido para a atualização de um preço
     * @param preco atributo requerido para a atualização de um preço
     * @param id atributo requerido para a atualização de um preço
     */
    public boolean atualizarPreco(String nome, Double preco, int id) {
        String sql = "UPDATE produtos set nome = ?, preco_unitario = ? WHERE idProduto = ?";
        try (Connection connection = Conexao.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setInt(3, id);

            int linhasAfetadas = statement.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException erro) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, erro);
            return false;
        }
    }

    /** Método para deletar produto 
     * @author GabrielaBonatelliPrates
     * @param idProduto atributo necessario para apagar um produto do banco de dados
     * @return retorna o delete de um produto efetivamente
     */
    public boolean deletarProdutoBD(int idProduto) {
        deletarProduto(idProduto);
        return true;
    }

    /** Método para deletar produto do banco de dados
     * @author GabrielaBonatelliPrates
     * @param idProduto atributo necessario para apagar um produto
     */
    public boolean deletarProduto(int idProduto) {
        String sql = "DELETE FROM produtos WHERE idProduto = ?";
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

    /**
     *
     * @param nomeProduto atributo necessário para inserir o nome de um produto a uma lista
     * @param id atributo necessário para inserir o id de um produto a uma lista
     * @param precoUnit atributo necessário para inserir o preço unitario de um produto a uma lista
     * @param unidadeProduto atributo necessário para inserir a unidade de medida de um produto a uma lista
     * @param quantidadeEstoque atributo necessário para inserir a quantidade em estoque de um produto a uma lista
     * @param estoqueMinimo atributo necessário para inserir a quantidade minima em estoque de um produto a uma lista
     * @param estoqueMaximo atributo necessário para inserir a quantidade minima em estoque de um produto a uma lista
     * @param categoria atributo necessário para inserir a categoria de um produto a uma lista
     * @return insere o produto à lista
     */
    public List<Produto> insereLista(String nomeProduto, int id, double precoUnit, String unidadeProduto, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, Categoria categoria) {
        Produto produto = new Produto(nomeProduto, id, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo, estoqueMaximo, categoria);
        produtos.add(produto); //adiciona o objeto criado à lista produtos 
        return produtos; //retorna a lista atualizada
    }
    
    /** Método que carrega um produto pelo id
     *
     * @param idPesquisado parametro necessario para buscar um produto pelo id
     * @return retorna o produto buscado
     */
    public Produto buscarPorId(int idPesquisado) { //busca um produto específico no banco através do id
        Connection connection = Conexao.conectar();
        Produto produto = null; //inicializa o objeto que será retornado
        Categoria categoria = null; //inicializa o objeto que será retornado

        String sql = "SELECT idProduto, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos WHERE idProduto = ?"; //query para buscar produto por id

        try {
            PreparedStatement statement = connection.prepareStatement(sql); //prepara a query
            statement.setInt(1, idPesquisado); //define o valor do id como parâmetro da query

            ResultSet resultSet = statement.executeQuery(); //executa a consulta

            if (resultSet.next()) {
                produto = new Produto();
                categoria = new Categoria();
                produto.setIdProduto(resultSet.getInt("idProduto"));
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

    /** Método que cria a ficha do produto
     *
     * @param nomePesquisado parametro necessario para mostrar a ficha de um produto quando este é pesquisado
     * @return retorna o produto e todas as suas atribuições
     */
    public String fichaProduto(String nomePesquisado) {
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
    
    /** Método que verifica o status do estoque do produto
     *
     * @param nomePesquisado parametro necessario para verificar a situação de um produto
     * @return retorna o status do produto 
     */
    public String verificaProduto(String nomePesquisado) {
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

    /** Método para pegar a lista de todos os produtos
     *
     * @return retorna uma lista atualizada dos produtos
     */
    public List<Produto> pegarProdutos() {
        listaAtualizada.clear();

        String sql = "SELECT idProduto, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos";

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Produto objeto = new Produto();
                objeto.setIdProduto(resultSet.getInt("idProduto"));
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

                listaAtualizada.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAtualizada;
    }

    /**Método para pegar lista de produtos numa categoria especifica
     *
     * @param categoriaPesquisada parametro para efetivar o metodo produtosCategoria
     * @return retorna os produtos cuja categoria é comum entre eles
     */
    public List<Produto> produtosCategoria(Categoria categoriaPesquisada) {
        List<Produto> todosProdutos = pegarProdutos(); //lista com todos os produtos
        List<Produto> produtoCategoria = new ArrayList<>(); //arraylist que vai contem os produtos numa mesma categoria (p posteriormente pegar o tamanho dessa lista)

        for (Produto produto : todosProdutos) {
            Categoria categoria = produto.getCategoria(); //pega o atributo categoria de cada produto

            //boolean para verificar se é a mesma categoria
            boolean mesmaCategoria
                    = categoria.getNomeCategoria().equals(categoriaPesquisada.getNomeCategoria())
                    && categoria.getTamanho().equals(categoriaPesquisada.getTamanho())
                    && categoria.getEmbalagem().equals(categoriaPesquisada.getEmbalagem());

            if (mesmaCategoria && !produtoCategoria.contains(produto)) {
                produtoCategoria.add(produto);
            }
        }

        return produtoCategoria; //lista com produtos únicos dessa categoria
    }

    /**  Método para pegar a lista de todos os produtos em ordem alfabética
     * @author GabrielaBonatelliPrates
     * @return retorna uma lista de produtos atualizada e organizada em ordem alfabetica
     */
    public List<Produto> produtosOrdemAlfabética() {
        listaAtualizada.clear();

        String sql = "SELECT idProduto, nome, preco_unitario, unidade, estoque_atual, estoque_minimo, estoque_maximo, nome_categoria, tamanho, embalagem FROM produtos ORDER BY nome ASC";

        try (Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Produto objeto = new Produto();
                objeto.setIdProduto(resultSet.getInt("idProduto"));
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

                listaAtualizada.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAtualizada;
    }

    /** 
     *
     * @return retorna produtos cuja quantidade em estoque esteja acima do maximo permitido
     */
    public List<Produto> pegarProdutosAcimaMaximo() {
        List<Produto> verificarProdutos = pegarProdutos();
        List<Produto> produtosAcima = new ArrayList<>();
        for (Produto produto : verificarProdutos) {
            if (produto.getQuantidadeEstoque() > produto.getEstoqueMaximo()) {
                produtosAcima.add(produto);
            }
        }
        return produtosAcima;
    }

    /**
     *
     * @return retorna produtos cuja quantidade em estoque esteja abaixo do minimo permitido
     */
    public List<Produto> pegarProdutosAbaixoMinimo() {
        List<Produto> verificarProdutos = pegarProdutos();
        List<Produto> produtosAbaixo = new ArrayList<>();
        for (Produto produto : verificarProdutos) {
            if (produto.getQuantidadeEstoque() < produto.getEstoqueMinimo()) {
                produtosAbaixo.add(produto);
            }
        }
        return produtosAbaixo;
    }

    /**
     *
     * @return retorna o valor total do estoque
     */
    public double valorTotal() {
        double valorTotalEstoque = 0;
        List<Produto> todosProdutos = pegarProdutos();
        for (Produto produto : todosProdutos) {
            valorTotalEstoque += (produto.getPrecoUnit() * produto.getQuantidadeEstoque());
        }
        return valorTotalEstoque;
    }
    //metodo para aumentar quantidade ao estoque do produto

    /**
     *
     * @param idProduto parametro necessario para que o metodo funcione
     * @param quantidadeAdicionar parametro necessario para que o metodo funcione
     */
    public void adicionarQuantidade(int idProduto, int quantidadeAdicionar) {
        String sql = "UPDATE produtos SET estoque_atual = estoque_atual + ? WHERE idProduto = ?";

        try (
                Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantidadeAdicionar);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metodo para diminuir quantidade do estoque do produto

    /**
     *
     * @param idProduto parametro necessario para que o metodo funcione
     * @param quantidadeRetirar parametro necessario para que o metodo funcione
     */
    public void retirarQuantidade(int idProduto, int quantidadeRetirar) {
        String sql = "UPDATE produtos SET estoque_atual = estoque_atual - ? WHERE idProduto = ?";

        try (
                Connection connection = Conexao.conectar(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantidadeRetirar);
            stmt.setInt(2, idProduto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
