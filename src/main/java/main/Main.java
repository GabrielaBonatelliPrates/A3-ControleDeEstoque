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

    private static final FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal();

    public static void main(String[] args) {
        menuPrincipal.setVisible(true);
        Connection conexao = Conexao.conectar();
        //comentario para realizar commit;
    }
}