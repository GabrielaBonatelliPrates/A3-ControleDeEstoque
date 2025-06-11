package view;

import javax.swing.table.DefaultTableModel;
import dao.CategoriaDAO;
import java.net.MalformedURLException;
import java.net.URL;
import model.Categoria;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FrmGerenciarCategoria é um JFrame para atualizar e excluir categorias.
 *
 * @author Estermrn
 */
public class FrmGerenciarCategoria extends javax.swing.JFrame {
private CategoriaDAO categoriaDAO;
 private DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Id", "Nome", "Tamanho", "Embalagem"}, 0);

    /**
     *
     * @param categoriaDAO valor inicial de categoriaDAO
     */
    public FrmGerenciarCategoria(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
        initComponents();
        mostrarTabela();
        setExtendedState(FrmGerenciarCategoria.MAXIMIZED_BOTH);

    }

    /**
     * Atualiza a tabela sempre que a janela for aberta.
     */
    public void mostrarTabela() {
        modelo.setRowCount(0);
        modelo.setNumRows(0);

        List<Categoria> todasCategorias = categoriaDAO.mostrarCategorias(); //puxa a lista de todas as categorias
        for (Categoria categoria : todasCategorias) { //percorre toda a lista de categorias adicionando nas colunas os dados requeridos
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria(),
                categoria.getTamanho(),
                categoria.getEmbalagem()

            });
        }
        JTGerenciarCategoria.setModel(modelo); //atualiza a tabela
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNomeCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFTamanho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JTFEmbalagem = new javax.swing.JTextField();
        JBAtualizar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTGerenciarCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Gerenciamento de Categorias");

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
        jLabel1.setText("jLabel1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setText("Atualizar categoria:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        JTFNomeCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tamanho:");

        JTFTamanho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Embalagem:");

        JTFEmbalagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JBAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBAtualizar.setText("Atualizar informações");
        JBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAtualizarActionPerformed(evt);
            }
        });

        JBVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBExcluir.setText("Excluir categoria");
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

        JTGerenciarCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTGerenciarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTGerenciarCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTGerenciarCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(414, 414, 414)
                                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(JBAtualizar)
                                .addGap(45, 45, 45)
                                .addComponent(JBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFEmbalagem, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(4, 4, 4)
                                            .addComponent(JTFNomeCategoria))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFTamanho)))
                                    .addComponent(jLabel4))
                                .addGap(847, 847, 847)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1436, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(418, 418, 418)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1447, 1447, 1447))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAtualizarActionPerformed
        try {
            int idCategoria = 0;
            String nomeCategoria = "";
            String tamanho = "";
            String embalagem = "";

            if (this.JTFNomeCategoria.getText().length() < 2) {
                throw new Mensagem("O nome da categoria deve conter ao menos 2 caracteres!");
            } else {
                nomeCategoria = this.JTFNomeCategoria.getText();
            }

            if (this.JTFTamanho.getText().length() < 1) {
                throw new Mensagem("O tamanho deve conter ao menos 1 caractere!");
            } else {
                tamanho = this.JTFTamanho.getText();
            }

            if (this.JTFEmbalagem.getText().length() < 2) {
                throw new Mensagem("A embalagem deve conter ao menos 2 caracteres!");
            } else {
                embalagem = this.JTFEmbalagem.getText();
            }

            if (this.JTGerenciarCategoria.getSelectedRow() == -1) {
                throw new Mensagem("Você precisa selecionar uma categoria para poder alterá-la");
            } else {
                idCategoria = Integer.parseInt(this.JTGerenciarCategoria.getValueAt(this.JTGerenciarCategoria.getSelectedRow(), 0).toString());
            }

            if (this.categoriaDAO.atualizarCategoria(nomeCategoria, tamanho, embalagem, idCategoria)) {
                this.JTFNomeCategoria.setText("");
                this.JTFTamanho.setText("");
                this.JTFEmbalagem.setText("");
                JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");
            }

        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        } finally {
            mostrarTabela();
        }
    }//GEN-LAST:event_JBAtualizarActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
        try {
            int idCategoria = 0;

            if (this.JTGerenciarCategoria.getSelectedRow() == -1) {
                throw new Mensagem("Você precisa selecionar uma categoria para poder exclui-lá");
            } else {
                idCategoria = Integer.parseInt(this.JTGerenciarCategoria.getValueAt(this.JTGerenciarCategoria.getSelectedRow(), 0).toString());
            }

 ImageIcon icone = null;
        //url do icone para as mensagens
          URL url;
        try {
            url = new URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/caixa_logo_JOption.png");
            //icone para as mensagens
          icone = new ImageIcon(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            String[] confirma = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null, "Quer mesmo excluir a categoria?", "Confirma",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icone, confirma, confirma[0]);
            
            if (resposta == 0) {
                if (this.categoriaDAO.deletarCategoria(idCategoria)) {
                    this.JTFNomeCategoria.setText("");
                    this.JTFTamanho.setText("");
                    this.JTFEmbalagem.setText("");
                    JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");
                }
            }

        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            mostrarTabela();
        }
    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JTGerenciarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTGerenciarCategoriaMouseClicked
         if (this.JTGerenciarCategoria.getSelectedRow() != -1) {
            String nomeCategoria = this.JTGerenciarCategoria.getValueAt(this.JTGerenciarCategoria.getSelectedRow(), 1).toString();
            String tamanho = this.JTGerenciarCategoria.getValueAt(this.JTGerenciarCategoria.getSelectedRow(), 2).toString();
            String embalagem = this.JTGerenciarCategoria.getValueAt(this.JTGerenciarCategoria.getSelectedRow(), 3).toString();

            this.JTFNomeCategoria.setText(nomeCategoria);
            this.JTFTamanho.setText(tamanho);
            this.JTFEmbalagem.setText(embalagem);
        }
    }//GEN-LAST:event_JTGerenciarCategoriaMouseClicked

    /**
     *
     * @param args método principal de FrmGerenciarCategoria
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
            java.util.logging.Logger.getLogger(FrmGerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CategoriaDAO categoriaDAO = null;
                new FrmGerenciarCategoria(categoriaDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAtualizar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFEmbalagem;
    private javax.swing.JTextField JTFNomeCategoria;
    private javax.swing.JTextField JTFTamanho;
    private javax.swing.JTable JTGerenciarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
