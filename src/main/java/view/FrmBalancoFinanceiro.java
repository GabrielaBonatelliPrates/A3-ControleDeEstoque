package view;

import controller.EmiteRelatorio;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import java.text.NumberFormat;
import java.util.Locale;

public class FrmBalancoFinanceiro extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Id", "Produto", "Quantidade", "Preço Unitário (R$)", "Preço Total Produto (R$)", "Preço Total Estoque (R$)"}, 0);
    private double valorTotalEstoque;

    public FrmBalancoFinanceiro(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
        initComponents();
        mostraTabela();
        setExtendedState(FrmBalancoFinanceiro.MAXIMIZED_BOTH);
        
    }
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balanco Financeiro");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1436, 955));
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

        jLabel1.setFont(new java.awt.Font("Inter 18pt Light", 0, 25)); // NOI18N
        jLabel1.setText("Valor total do Estoque (R$):");

        JLValorTotalEstoque.setFont(new java.awt.Font("Inter 18pt", 0, 25)); // NOI18N
        JLValorTotalEstoque.setText("0,00");

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Inter 18pt Light", 0, 29)); // NOI18N
        jLabel2.setText("Balanço Financeiro");

        JBEmitirRelatorio.setText("Exportar Tabela");
        JBEmitirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmitirRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JLValorTotalEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(1195, Short.MAX_VALUE)
                    .addComponent(JBEmitirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JLValorTotalEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(737, Short.MAX_VALUE)
                    .addComponent(JBEmitirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(181, 181, 181)))
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
