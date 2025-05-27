package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/controle_estoque";
    private static final String USUARIO = "root";
    private static final String SENHA = "2007";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}