package view;

import controller.EmiteRelatorio;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import java.text.NumberFormat;
import java.util.Locale;

/**FrmBalancoFinanceiro é um JFrame que mostra a relação de balanço financeiro entre produtos e valor de estoque 
 *
 * @author Mateo-Padilla
 */
public class FrmBalancoFinanceiro extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Id", "Produto", "Quantidade", "Preço Unitário (R$)", "Preço Total Produto (R$)", "Preço Total Estoque (R$)"}, 0);
    private double valorTotalEstoque;

    /**
     *
     * @param produtoDAO valor inicial de produtoDAO
     */
    public FrmBalancoFinanceiro(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
        initComponents();
        mostraTabela();
        setExtendedState(FrmBalancoFinanceiro.MAXIMIZED_BOTH);
        
    }
    
    /**
     * @author laispaivaportela
     *  Método para carregar na table os dados para o relatório
     */
    public void mostraTabela() {

        modelo.setRowCount(0); //limpa a tabela
        modelo.setNumRows(0); //posiciona na primeira linha da tabela

        List<Produto> todosProdutos = produtoDAO.pegarProdutos(); //acha os produtos acima do máximo

   //formata para moeda braseira
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

 for (Produto produto : todosProdutos) { //adiciona à tabela
        modelo.addRow(new Object[]{
            produto.getIdProduto(),
            produto.getNomeProduto(),
            produto.getQuantidadeEstoque(),
           produto.getPrecoUnit(),
            produto.getPrecoUnit() * produto.getQuantidadeEstoque(),
            null
        });
    }
        //a coluna do preço total do estoque inteiro fica vazia nas linhas dos produtos
        valorTotalEstoque = produtoDAO.valorTotal();
        //adiciona info do valor total do estoque na ultima linha de todas
        modelo.addRow(new Object[]{
            null,
            null,
            null,
            null,
            null,
            valorTotalEstoque
        });
        
         
         JLValorTotalEstoque.setText("Total: " + formatoMoeda.format(valorTotalEstoque)); //manda o valor total do estoque formatado pra moeda br
         JTBalancoFinanceiro.setModel(modelo);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTBalancoFinanceiro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JLValorTotalEstoque = new javax.swing.JLabel();
        JBVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JBEmitirRelatorio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balanco Financeiro");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JTBalancoFinanceiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Preço Unitário", "Preço Total", "Preço Total Estoque"
            }
        ));
        jScrollPane1.setViewportView(JTBalancoFinanceiro);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        jLabel1.setText("Valor total do Estoque (R$):");

        JLValorTotalEstoque.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        JLValorTotalEstoque.setText("0,00");

        JBVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Balanço Financeiro");

        JBEmitirRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBEmitirRelatorio.setText("Exportar Tabela");
        JBEmitirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmitirRelatorioActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/Caixa_logo%20(2).png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JLValorTotalEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBEmitirRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JLValorTotalEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(519, 519, 519)
                        .addComponent(JBEmitirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        mostraTabela();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostraTabela();
    }//GEN-LAST:event_formWindowOpened

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBEmitirRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmitirRelatorioActionPerformed
        EmiteRelatorio emiteRelatorio = new EmiteRelatorio();
        emiteRelatorio.exportaArquivo(JTBalancoFinanceiro);
    }//GEN-LAST:event_JBEmitirRelatorioActionPerformed

    /**
     *
     * @param args metodo principal de FrmBalancoFinanceiro 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBalancoFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                new FrmBalancoFinanceiro(produtoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEmitirRelatorio;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JLabel JLValorTotalEstoque;
    private javax.swing.JTable JTBalancoFinanceiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
