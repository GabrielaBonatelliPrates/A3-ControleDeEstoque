package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**classe Conexao é uma classe que conecta o sistema com o banco de dados
 *
 * @author Mateo-Padilla
 */
public class Conexao {

    /**
     * @author laispaivaportela
     * @return connection retorna a conexão efetivada corretamente
     */
    public static Connection conectar() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver"; //nome do driver
            Class.forName(driver); //carrega a classe do driver

            String url = "jdbc:mysql://127.0.0.1:3306/controle_estoque_a3"; //url de conexão com o banco de dados
            String user = "root"; //nome de usuário do banco de dados
            String senha = "senha"; //senha do banco de dados

            connection = DriverManager.getConnection(url, user, senha); //vai tentar conectar com o banco
            
            return connection; //retorna o objeto de conexão
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado."); //se não encontrar o drive vai enviar pro terminal que ele não foi encontrado
            e.printStackTrace(); //exibe o erro completo no console
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar..."); //se tiver algum erro ao tentar conectar vai enviar pro terminal que não foi possível conectar
            e.printStackTrace(); //exibe os detalhes do erro de SQL
            return null;
        }
    }
}
