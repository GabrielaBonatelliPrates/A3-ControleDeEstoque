package view;

import javax.swing.JOptionPane;

/** FrmSobre é um JFrame o qual explica sobre a equipe e o projeto
 *
 * @author Davi-Wolff
 */
public class FrmSobre extends javax.swing.JFrame {

    /**
     *author Davi-Wolff
     */
    public FrmSobre() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JLSobre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea JTASobre = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.JLabel() {
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
        jLabel1.setText("Estampa...");

        JLSobre.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        JLSobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLSobre.setText("Sobre");

        JTASobre.setColumns(20);
        JTASobre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTASobre.setRows(5);
        JTASobre.setText("    Este é um projeto realizados por alunos da UNISUL, de uma sistema de armazenamento de uma loja, com banco de dados e interface gráfica. \n\n\n                                                                                      Dentre os colaboradores temos:\n\n\n\t        Nomes:\t\t                    Usuários do GitHub (Caso tenha interesse em nosso trabalho):\n\n\tDavi Wolff de Abreu\t\t\tDavi-Wolff\n\tEster da Rosa Mariani\t\t\tEstermrn\n\tGabriela Bonatelli Prates\t\t\tGabrielaBonatelliPrates\n\tLaís Paiva Portela\t\t\tlaispaivaportela\n\tMateo Alessandro Padilla Chalela\t\tMateo-Padilla\n\n\n              Nós não tivemos separação específica de tarefas. Entretanto é com orgulho que dizemos que todos nós trabalhamos em conjunto.\n");
        JTASobre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 0))));
        JTASobre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTASobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTASobreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTASobre);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(630, 630, 630)
                        .addComponent(JLSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * metodo para mandar aparecer um "pop-up" com um coração
     * 
     *author Davi-Wolff
     */
    private void JTASobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTASobreMouseClicked
        JOptionPane.showMessageDialog(null, """
                                            \u2500\u2500\u2500\u2500(\u2665)(\u2665)(\u2665)\u2500\u2500\u2500\u2500(\u2665)(\u2665)(\u2665)
                                            \u2500\u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500\u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500\u2500\u2500\u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500\u2500\u2500\u2500\u2500\u2500(\u2665)\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500(\u2665)\u2588\u2588\u2588\u2588(\u2665)
                                            \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500(\u2665)\u2588\u2588(\u2665)
                                            \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500(\u2665)""");
    }//GEN-LAST:event_JTASobreMouseClicked

    /**
     *
     * @param args metodo inicializador
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
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
