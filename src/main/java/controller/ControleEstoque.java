package controller;


import dao.ProdutoDAO;
import dao.CategoriaDAO;
import dao.MovimentacaoDAO;
import java.sql.SQLException;
import view.FrmMenuPrincipal;

/**classe ControleEstoque é uma classe utilizada para gerenciar a movimentação do estoque
 *
 * @author laispaivaportela
 */
public class ControleEstoque {
    

    /**metodos de instancia para efetivar o controle do estoque
     *
     * @param produtoDAO instancia um novo produto do banco de dados
     * @param categoriaDAO instancia uma nova categoria do banco de dados
     * @param movimentacaoDAO instancia uma nova movimentação do banco de dados
     */
    protected CategoriaDAO categoriaDAO = new CategoriaDAO();
    protected ProdutoDAO produtoDAO = new ProdutoDAO(categoriaDAO);
    protected MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(produtoDAO);


    /**
     * 
     *@param iniciaAplicação metodo que inicia o sistema
     */
    public void iniciaAplicação() throws SQLException{
 
        //instancia a interface gráfica do menu principal
         FrmMenuPrincipal telaMenu = new FrmMenuPrincipal(produtoDAO, categoriaDAO, movimentacaoDAO);
         //deixa ele visível
         telaMenu.setVisible(true);
         produtoDAO.pegarProdutos();
    }

}
