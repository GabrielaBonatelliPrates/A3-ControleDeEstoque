/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author laispaivaportela
 */
import main.Main;
import dao.ProdutoDAO;
import dao.CategoriaDAO;
import dao.MovimentacaoDAO;
import view.FrmMenuPrincipal;
import javax.swing.JOptionPane;

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
