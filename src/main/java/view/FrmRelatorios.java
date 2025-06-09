package view;
import dao.ProdutoDAO;
public class FrmRelatorios extends javax.swing.JFrame {
private ProdutoDAO produtoDAO;

    public FrmRelatorios(ProdutoDAO produtoDAO) {
        initComponents();
        this.produtoDAO = produtoDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBListaDePrecos = new javax.swing.JButton();
        JBBalancoFinanceiro = new javax.swing.JButton();
        JBProdutos = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JBAcimaMaximo = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JBListaDePrecos.setText("Lista de preços");
        JBListaDePrecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBListaDePrecosMouseClicked(evt);
            }
        });

        JBBalancoFinanceiro.setText("Balanço financeiro");
        JBBalancoFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBBalancoFinanceiroMouseClicked(evt);
            }
        });

        JBProdutos.setText("Lista de produtos");
        JBProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBProdutosMouseClicked(evt);
            }
        });
        JBProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutosActionPerformed(evt);
            }
        });

        jButton4.setText("Abaixo da quantidade mínima");

        JBAcimaMaximo.setText("Acima da quantidade máxima ");
        JBAcimaMaximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBAcimaMaximoMouseClicked(evt);
            }
        });

        jButton7.setText("Voltar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Relatórios");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(JBAcimaMaximo)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JBListaDePrecos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBBalancoFinanceiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBProdutos)))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBListaDePrecos)
                    .addComponent(JBBalancoFinanceiro)
                    .addComponent(JBProdutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAcimaMaximo)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutosActionPerformed
        new FrmProdutos(produtoDAO).setVisible(true);
    }//GEN-LAST:event_JBProdutosActionPerformed

    private void JBBalancoFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBBalancoFinanceiroMouseClicked
        new FrmBalancoFinanceiro(produtoDAO).setVisible(true);
    }//GEN-LAST:event_JBBalancoFinanceiroMouseClicked

    private void JBAcimaMaximoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBAcimaMaximoMouseClicked
                new FrmEstoqueMaximo(produtoDAO).setVisible(true);

    }//GEN-LAST:event_JBAcimaMaximoMouseClicked

    private void JBListaDePrecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBListaDePrecosMouseClicked
                new FrmListaPrecos(produtoDAO).setVisible(true);
    }//GEN-LAST:event_JBListaDePrecosMouseClicked

    private void JBProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBProdutosMouseClicked
                new FrmProdutos(produtoDAO).setVisible(true);
    }//GEN-LAST:event_JBProdutosMouseClicked

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(FrmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                new FrmRelatorios(produtoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAcimaMaximo;
    private javax.swing.JButton JBBalancoFinanceiro;
    private javax.swing.JButton JBListaDePrecos;
    private javax.swing.JButton JBProdutos;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
