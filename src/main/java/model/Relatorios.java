package model;
import java.util.List;
import java.util.ArrayList;

public class Relatorios {

    private List<List<String>> lista;
    private int NumeroLinhas;

    public Relatorios() {
        this.lista = new ArrayList<>();
        this.lista.add(new ArrayList<>()); // Adiciona a primeira linha da tabela
        this.NumeroLinhas = 0;
    }

    public void addElement(String elemento) {
        if (NumeroLinhas >= 8) {
//Cria nova linha quando a ultima adicionada foi preenchida.
        lista.add(new ArrayList<>());
            NumeroLinhas = 0;
        }

        // Adiciona um elemento à linha atual.
        lista.get(lista.size() - 1).add(elemento);
        NumeroLinhas++;
    }

    public void adicionarCabecalho() {
        addElement("Nome");
        addElement("Preço Unitário");
        addElement("Unidade de Produto");
        addElement("Quantidade em Estoque");
        addElement("Quantidade em Estoque mínima");
        addElement("Quantidade em Estoque máxima");
        addElement("ID");
        addElement("Categoria");
    }

    public void adicionarProduto(Produto produto) {
        addElement(produto.getNomeProduto());
        addElement(String.valueOf(produto.getPrecoUnit()));
        addElement(produto.getUnidadeProduto());
        addElement(String.valueOf(produto.getQuantidadeEstoque()));
        addElement(String.valueOf(produto.getEstoqueMinimo()));
        addElement(String.valueOf(produto.getEstoqueMaximo()));
        addElement(String.valueOf(produto.getIdProduto()));
        addElement(produto.getNomeCategoria());
    }
    // Extrai o elemento de uma posição especifica.
    public void displayReport() {
        System.out.println("\n=== RELATÓRIO ===");
        for (List<String> row : lista) {
            // Print separator line
            System.out.println("-".repeat(100));

            // Mostra cada elemento em um posição específica.
            for (String element : row) {
                System.out.printf("%-12s | ", element);
            }
            System.out.println();
        }
        System.out.println("-".repeat(100));
    }

    public String[][] toArray() {
        String[][] result = new String[lista.size()][];
        for (int i = 0; i < lista.size(); i++) {
            List<String> row = lista.get(i);
            result[i] = row.toArray(new String[0]);
        }
        return result;
    }


    public void MostrarRelatorio() {
        System.out.println("\n=== Relatório de Balanço Financeiro===");
        String[][] array = toArray();
        for (String[] row : array) {
            System.out.println("-".repeat(100));
            for (String element : row) {
                System.out.printf("%-12s | ", element);
            }
            System.out.println();
        }
        System.out.println("-".repeat(100));
    }

    public static void gerarRelatorio(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados no estoque.");
            return;
        }

        System.out.println("=== RELATÓRIO FINANCEIRO DO ESTOQUE ===");
        double totalEstoque = 0;

        for (Produto p : produtos) {
            double valorTotal = p.getPrecoUnit() * p.getQuantidadeEstoque();
            System.out.printf("Produto: %-20s | Quantidade: %3d | Preço Unitário: R$ %.2f | Total: R$ %.2f\n",
                    p.getNomeProduto(), p.getQuantidadeEstoque(), p.getPrecoUnit(), valorTotal);
            totalEstoque += valorTotal;
        }

        System.out.println("--------------------------------------------");
        System.out.printf("VALOR TOTAL DO ESTOQUE: R$ %.2f\n", totalEstoque);
    }
}