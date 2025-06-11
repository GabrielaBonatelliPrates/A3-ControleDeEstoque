package view;

import dao.CategoriaDAO;
import dao.ProdutoDAO;

/**
 * FrmRelatorios é um JFrame que oferece os tipos de relatorios do sistema
 *
 * @author Mateo-Padilla
 */
public class FrmRelatorios extends javax.swing.JFrame {

    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    /**
     *
     * @param produtoDAO valor inicial de produtoDAO
     */
    public FrmRelatorios(ProdutoDAO produtoDAO) {
        initComponents();
        this.produtoDAO = produtoDAO;
        this.categoriaDAO = categoriaDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBListaDePrecos = new javax.swing.JButton();
        JBBalancoFinanceiro = new javax.swing.JButton();
        JBProdutosCategoria = new javax.swing.JButton();
        JBAbaixoMinimo = new javax.swing.JButton();
        JBAcimaMaximo = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JBListaDePrecos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBListaDePrecos.setText("Lista de preços");
        JBListaDePrecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBListaDePrecosMouseClicked(evt);
            }
        });
        JBListaDePrecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBListaDePrecosActionPerformed(evt);
            }
        });

        JBBalancoFinanceiro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBBalancoFinanceiro.setText("Balanço financeiro");
        JBBalancoFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBBalancoFinanceiroMouseClicked(evt);
            }
        });

        JBProdutosCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBProdutosCategoria.setText("Quantidade de produtos por categoria");
        JBProdutosCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBProdutosCategoriaMouseClicked(evt);
            }
        });
        JBProdutosCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBProdutosCategoriaActionPerformed(evt);
            }
        });

        JBAbaixoMinimo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBAbaixoMinimo.setText("Abaixo da quantidade mínima");
        JBAbaixoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAbaixoMinimoActionPerformed(evt);
            }
        });

        JBAcimaMaximo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBAcimaMaximo.setText("Acima da quantidade máxima ");
        JBAcimaMaximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBAcimaMaximoMouseClicked(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Relatórios");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.JLabel() {
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
        jLabel2.setText("label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JBProdutosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(232, 232, 232)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JBListaDePrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBBalancoFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(232, 232, 232)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JBAcimaMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBAbaixoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBListaDePrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAbaixoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAcimaMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBalancoFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBProdutosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(225, 225, 225))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBProdutosCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBProdutosCategoriaActionPerformed
        //instancia a interface gráfica do relatório
        FrmProdutoCategoria telaProdutoCategoria = new FrmProdutoCategoria(produtoDAO, categoriaDAO);
        //deixa ela vísível   
        telaProdutoCategoria.setVisible(true);
    }//GEN-LAST:event_JBProdutosCategoriaActionPerformed

    private void JBBalancoFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBBalancoFinanceiroMouseClicked
        //instancia a interface gráfica do balanço financeiro
        FrmBalancoFinanceiro balancoFinanceiro = new FrmBalancoFinanceiro(produtoDAO);
        //deixa ela vísível
        balancoFinanceiro.setVisible(true);
    }//GEN-LAST:event_JBBalancoFinanceiroMouseClicked

    private void JBAcimaMaximoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBAcimaMaximoMouseClicked
        //instancia a interface gráfica do relatório
        FrmEstoqueMaximo telaEstoqueMaximo = new FrmEstoqueMaximo(produtoDAO);
        //deixa ela vísível
        telaEstoqueMaximo.setVisible(true);

    }//GEN-LAST:event_JBAcimaMaximoMouseClicked

    private void JBListaDePrecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBListaDePrecosMouseClicked
    }//GEN-LAST:event_JBListaDePrecosMouseClicked

    private void JBProdutosCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBProdutosCategoriaMouseClicked
    }//GEN-LAST:event_JBProdutosCategoriaMouseClicked

    private void JBListaDePrecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBListaDePrecosActionPerformed
        //instancia a interface gráfica do relatório
        FrmListaPrecos telaListaDePreco = new FrmListaPrecos(produtoDAO);
        //deixa ela visível
        telaListaDePreco.setVisible(true);
    }//GEN-LAST:event_JBListaDePrecosActionPerformed

    private void JBAbaixoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAbaixoMinimoActionPerformed
        //instancia a interface gráfica do relatório
        FrmEstoqueMinimo telaEstoqueMinimo = new FrmEstoqueMinimo(produtoDAO);
        //deixa ela vísível
        telaEstoqueMinimo.setVisible(true);
    }//GEN-LAST:event_JBAbaixoMinimoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     *
     * @param args método principal de FrmRelatorios
     */
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
    private javax.swing.JButton JBAbaixoMinimo;
    private javax.swing.JButton JBAcimaMaximo;
    private javax.swing.JButton JBBalancoFinanceiro;
    private javax.swing.JButton JBListaDePrecos;
    private javax.swing.JButton JBProdutosCategoria;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
