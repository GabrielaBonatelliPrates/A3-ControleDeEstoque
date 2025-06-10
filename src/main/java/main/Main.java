package main;

import controller.ControleEstoque;

/**classe main é uma classe que executa o programa
 *
 * @author Mateo-Padilla
 */
public class Main {

    /**
     *
     * @param args metodo principal do projeto
     */
    public static void main(String[] args) {
        
        //instancia a classe "ControleEstoque"
        ControleEstoque controleEstoque = new ControleEstoque();
        //inicia a aplicação
        controleEstoque.iniciaAplicação();
    }
}