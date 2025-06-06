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

public class Main {

    public static void main(String[] args) {
        
        FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();
        menuPrincipal.setVisible(true);
        
    }
}