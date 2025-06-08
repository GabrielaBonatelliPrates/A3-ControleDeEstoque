
package controller;


import dao.ProdutoDAO;
import dao.CategoriaDAO;
import dao.MovimentacaoDAO;
import view.FrmMenuPrincipal;

public class ControleEstoque {
    //instancia os DAO
    protected ProdutoDAO produtoDAO = new ProdutoDAO();
    protected CategoriaDAO categoriaDAO = new CategoriaDAO();
    protected MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
         
    //inicia a aplicação
    public void iniciaAplicação(){
        //instancia a interface gráfica do menu principal
         FrmMenuPrincipal telaMenu = new FrmMenuPrincipal(produtoDAO, categoriaDAO);
         //deixa ele visível
         telaMenu.setVisible(true);
    }
   
    
    
}
