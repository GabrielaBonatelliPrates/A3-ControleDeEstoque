package view;

import model.Categoria;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import dao.CategoriaDAO;
import javax.swing.JOptionPane;

public class FrmGerenciarCategoria extends javax.swing.JFrame {
private CategoriaDAO categoriaDAO;

    public FrmGerenciarCategoria(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
        initComponents();
        this.novaTabela();

    }

    public void novaTabela() {

        DefaultTableModel preencher = (DefaultTableModel) this.JTGerenciarCategoria.getModel();
        preencher.setNumRows(0);
        List<Categoria> buscarCategoria = categoriaDAO.pegarCategorias();
        for (Categoria cat : buscarCategoria) {
            preencher.addRow(new Object[]{
                cat.getIdCategoria(),
                cat.getNomeCategoria(),
                cat.getTamanho(),
                cat.getEmbalagem()
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTGerenciarCategoria = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Gerenciamento de Categorias");

        jLabel1.setText("jLabel1");

        JTGerenciarCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tamanho", "Embalagem"
            }
        ));
        JTGerenciarCategoria.setPreferredSize(new java.awt.Dimension(750, 80));
        JTGerenciarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTGerenciarCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTGerenciarCategoria);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Atualizar categoria:");

        jLabel2.setText("Nome:");

        jLabel5.setText("Tamanho:");

        jLabel6.setText("Embalagem:");

        JBAtualizar.setText("Atualizar informações");
        JBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAtualizarActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBExcluir.setText("Excluir categoria");
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(476, 476, 476)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFEmbalagem))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFTamanho))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(509, 509, 509)
                        .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(JBAtualizar)
                        .addGap(37, 37, 37)
                        .addComponent(JBExcluir)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAtualizar)
                    .addComponent(JBVoltar)
                    .addComponent(JBExcluir))
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
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            }

        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        } finally {
            novaTabela();
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

            String[] confirma = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null, "Quer mesmo excluir a categoria?", "Confirma",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirma, confirma[0]);

            if (resposta == 0) {
                if (this.categoriaDAO.deletarCategoria(idCategoria)) {
                    this.JTFNomeCategoria.setText("");
                    this.JTFTamanho.setText("");
                    this.JTFEmbalagem.setText("");
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                }
            }

        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            novaTabela();
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
