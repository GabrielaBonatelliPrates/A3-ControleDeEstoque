package view;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import controller.EmiteRelatorio;

/** FrmEstoqueMaximo é um JFrame que mostra os produtos que estão com seus estoques acima do máximo
 *
 * @author Estermrn
 * @author Davi-Wolff
 */


public class FrmEstoqueMaximo extends javax.swing.JFrame {
private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Id", "Nome", "Estoque Atual", "Estoque Máximo"}, 0); //cria um modelo para a tabela
private ProdutoDAO produtoDAO;

    /**
     *
     * @param produtoDAO valor inicial do produtoDAO
     */
    public FrmEstoqueMaximo(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
        initComponents();
        this.carregaTabela();
        setExtendedState(FrmEstoqueMaximo.MAXIMIZED_BOTH);
    }

    /**
     *@author Davi-Wolff
     */
    public void carregaTabela() {
        
        modelo.setRowCount(0); //limpa a tabela
        modelo.setNumRows(0); //posiciona na primeira linha da tabela

        List<Produto> acimaMaximo = produtoDAO.pegarProdutosAcimaMaximo(); //acha os produtos acima do máximo
        
        for (Produto produto : acimaMaximo) { //adiciona à tabela
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getQuantidadeEstoque(),
                produto.getEstoqueMaximo(),});
        }
        JTEstoqueMaximo.setModel(modelo); //atualiza a tabela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEstoqueMaximo = new javax.swing.JTable();
        JBVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JBExportarTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque Maximo");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Acima do Estoque Máximo");

        JTEstoqueMaximo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "ID", "Quantidade", "Quantidade máxima"
            }
        ));
        jScrollPane1.setViewportView(JTEstoqueMaximo);

        JBVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        JBExportarTabela.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBExportarTabela.setText("Exportar relatório");
        JBExportarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1)
                        .addGap(279, 279, 279))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(436, 436, 436)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245)
                .addComponent(JBExportarTabela)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBExportarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBExportarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarTabelaActionPerformed
        EmiteRelatorio emiteRelatorio = new EmiteRelatorio();
        emiteRelatorio.exportaArquivo(JTEstoqueMaximo); //metodo que emite o relatorio
    }//GEN-LAST:event_JBExportarTabelaActionPerformed

    /**
     *
     * @param args método principal do EstoqueMaximo
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
            java.util.logging.Logger.getLogger(FrmEstoqueMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMaximo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                new FrmEstoqueMaximo(produtoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBExportarTabela;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTable JTEstoqueMaximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
