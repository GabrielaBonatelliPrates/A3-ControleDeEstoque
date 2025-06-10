package view;

import controller.EmiteRelatorio;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/** FrmEstoqueMinimo é um JFrame que mostra os produtos que estão com seus estoques abaixo do minimo
 *
 * @author Davi-Wolff
 */


public class FrmEstoqueMinimo extends javax.swing.JFrame {
private ProdutoDAO produtoDAO;
private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Id", "Nome", "Estoque Atual", "Estoque Mínimo"}, 0); //cria um modelo para a tabela
 
    /**
     *
     * @param produtoDAO valor inicial do produtoDAO
     */
    public FrmEstoqueMinimo(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
        initComponents();
        this.carregaTabela();    
        setExtendedState(FrmEstoqueMinimo.MAXIMIZED_BOTH);
    }
    
    /**
     *@author Davi-Wolff
     */
    public void carregaTabela() {
         modelo.setRowCount(0); //limpa a tabela
        modelo.setNumRows(0); //posiciona na primeira linha da tabela

        List<Produto> abaixoMinimo = produtoDAO.pegarProdutosAbaixoMinimo();    //acha os produtos abiaxo do minimo
        
        for (Produto produto : abaixoMinimo) {  //adiciona à tabela
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getQuantidadeEstoque(),
                produto.getEstoqueMinimo(),
            });
        }
         JTEstoqueMinimo.setModel(modelo);  //atualiza a tabela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLEstoqueMinimo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEstoqueMinimo = new javax.swing.JTable();
        JBVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JBExportarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLEstoqueMinimo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        JLEstoqueMinimo.setText("Abaixo do Estoque Mínimo");

        JTEstoqueMinimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "ID", "Quantidade", "Quantidade mínima"
            }
        ));
        jScrollPane1.setViewportView(JTEstoqueMinimo);

        JBVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        JBExportarRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBExportarRelatorio.setText("Exportar relatório");
        JBExportarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(JBExportarRelatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLEstoqueMinimo)
                .addGap(478, 478, 478))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLEstoqueMinimo)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBExportarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened
    /**
     * Chama a classe que emite os relatórios com os dados da tabela de estoque mínimo.
     * 
     * @author Estermrn
     * @param evt evento ao clicar no botão.
     */
    private void JBExportarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarRelatorioActionPerformed
        EmiteRelatorio emiteRelatorio = new EmiteRelatorio();
        emiteRelatorio.exportaArquivo(JTEstoqueMinimo);     //metodo que emite o relatorio
    }//GEN-LAST:event_JBExportarRelatorioActionPerformed

    /**
     *
     * @param args método principal do EstoqueMinimo
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
            java.util.logging.Logger.getLogger(FrmEstoqueMinimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMinimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMinimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstoqueMinimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                new FrmEstoqueMinimo(produtoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBExportarRelatorio;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JLabel JLEstoqueMinimo;
    private javax.swing.JTable JTEstoqueMinimo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
