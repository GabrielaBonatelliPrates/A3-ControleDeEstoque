package main;

import java.sql.Connection;
import java.sql.SQLException;
import dao.Conexao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Produto;
import model.Categoria;
import view.FrmMenuPrincipal;
import controller.ControleEstoque;

public class Main {

    public static void main(String[] args) {
        
        //instancia a classe "ControleEstoque"
        ControleEstoque controleEstoque = new ControleEstoque();
        //inicia a aplicação
        controleEstoque.iniciaAplicação();
    }
}