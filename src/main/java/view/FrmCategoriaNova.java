package view;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import model.Categoria;
import dao.ProdutoDAO;
import dao.CategoriaDAO;

public class FrmCategoriaNova extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    public List<Categoria> categorias = new ArrayList();
    

    public FrmCategoriaNova(ProdutoDAO produtoDAO, CategoriaDAO categoriaDAO) {
        this.produtoDAO = produtoDAO;
        this.categoriaDAO = categoriaDAO;
        initComponents();
        setExtendedState(FrmCategoriaNova.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNomeCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JBCadastrar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        JTFTamanho = new javax.swing.JTextField();
        JTFEmbalagem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("telaNovaCategoria");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nova Categoria");

        jLabel2.setText("Nome:");

        JTFNomeCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tamanho:");

        jLabel4.setText("Embalagem:");

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(JBCadastrar)
                        .addGap(46, 46, 46)
                        .addComponent(JBVoltar)))
                .addContainerGap(946, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCadastrar)
                    .addComponent(JBVoltar))
                .addContainerGap(720, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNomeCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeCategoriaActionPerformed

    private void JBVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_JBVoltarMouseClicked

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        try {
            //Recebe entrada do usuário
            String nomeCategoria = "";
            String tamanho = "";
            String embalagem = "";

            //Erro no nome da categoria
            if (this.JTFNomeCategoria.getText().length() < 2) {
                throw new Mensagem("O nome da categoria deve conter pelo menos 2 caracteres.");
            } else {
                nomeCategoria = this.JTFNomeCategoria.getText();
            }

            //Erro no tamanho da categoria
            if (this.JTFTamanho.getText().length() < 1) {
                throw new Mensagem("O tamanho do produto deve conter pelo menos 1 caractere. ");
            } else {
                tamanho = this.JTFTamanho.getText();
            }

            //Erro no tipo de embalagem
            if (this.JTFEmbalagem.getText().length() < 2) {
                throw new Mensagem("O tipo de emabalagem deve conter pelo menos 2 caracteres.");
            } else {
                embalagem = this.JTFEmbalagem.getText();
            }

            //Limpa os campos da interface
            this.JTFNomeCategoria.setText("");
            this.JTFTamanho.setText("");
            this.JTFEmbalagem.setText("");
            

            //Verifica se a categoria já existe
            boolean existe = categoriaDAO.verificaCategoria(nomeCategoria, tamanho, embalagem);
            if (existe) {
                JOptionPane.showMessageDialog(this, "Categoria já cadastrada anteriormente!");
            } else {

            }           
            
            //Criar categoria nova e mostrar possiível erro
            categoriaDAO.inserirCategoria(1, nomeCategoria, tamanho, embalagem);
            boolean criou = categoriaDAO.verificaCategoria(nomeCategoria, tamanho, embalagem);
            if (criou) {
                JOptionPane.showMessageDialog(this, "Categoria criada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar nova categoria, tente novamente!");
            }
            
        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCategoriaNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaNova.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                CategoriaDAO categoriaDAO = null;
                new FrmCategoriaNova(produtoDAO, categoriaDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFEmbalagem;
    private javax.swing.JTextField JTFNomeCategoria;
    private javax.swing.JTextField JTFTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
