package view;

import model.MovimentacaoEstoque;
import dao.MovimentacaoDAO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controller.ControleEstoque;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

public class FrmMovimentacao extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private Produto produto;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Produto> produtos;

    public FrmMovimentacao(ProdutoDAO produtoDAO, MovimentacaoDAO movimentacaoDAO) {
        initComponents();
        this.produto = new Produto();
        this.produtoDAO = produtoDAO;
        this.movimentacaoDAO = movimentacaoDAO;
        this.produtos = produtoDAO.pegarProdutos(); 
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLMovimentacao = new javax.swing.JLabel();
        JLProdutoMovimentacao = new javax.swing.JLabel();
        JTFProdutoMovimentacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JBAdicionar = new javax.swing.JButton();
        JBRemover = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        JTFQuantidadeMovimentacao = new javax.swing.JTextField();
        JLCodigoMovimentacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação de Estoque");

        JLMovimentacao.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JLMovimentacao.setText("Movimentação");

        JLProdutoMovimentacao.setText("Produto:");

        jLabel3.setText("Id:");

        jLabel4.setText("Quantidade:");

        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        JBRemover.setText("Remover");
        JBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRemoverActionPerformed(evt);
            }
        });

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBSair.setText("Fechar");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        JTFQuantidadeMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFQuantidadeMovimentacaoActionPerformed(evt);
            }
        });

        JLCodigoMovimentacao.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(JLMovimentacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLCodigoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFQuantidadeMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBLimpar)
                                .addGap(18, 18, 18)
                                .addComponent(JBAdicionar)
                                .addGap(26, 26, 26)
                                .addComponent(JBRemover)
                                .addGap(18, 18, 18)
                                .addComponent(JBSair)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(JLMovimentacao)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLProdutoMovimentacao)
                    .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JLCodigoMovimentacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTFQuantidadeMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAdicionar)
                    .addComponent(JBRemover)
                    .addComponent(JBSair)
                    .addComponent(JBLimpar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
 try {
            String nomeProduto = JTFProdutoMovimentacao.getText().trim();
            if (nomeProduto.isEmpty()) {
                throw new IllegalArgumentException("Informe o nome do produto.");
            }

            Produto produto = produtoDAO.buscarPorNome(nomeProduto);
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado.");
            }

            int quantidade = Integer.parseInt(JTFQuantidadeMovimentacao.getText().trim());
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
            }

            int idProduto = produto.getIdProduto();
            Date data = Date.from(Instant.now());
            String tipoMovimentacao = "entrada";
            MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
            movimentacao.setNomeProduto(nomeProduto);
            movimentacao.setIdProduto(idProduto);
            movimentacao.setDataMovimentacao(data);
            movimentacao.setQuantidadeMovimentada(quantidade);
            movimentacao.setTipoMovimentacao(tipoMovimentacao);
            movimentacaoDAO.cadastraMovimentacao(movimentacao);
            //movimentacaoDAO.inserirMovimentacao(idProduto, data, quantidade, nomeProduto, tipoMovimentacao);

            JOptionPane.showMessageDialog(null, "Movimentação de entrada registrada com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade válida.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_JBAdicionarActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        this.JTFProdutoMovimentacao.setText("");
        this.JLCodigoMovimentacao.setText("0");
        this.JTFQuantidadeMovimentacao.setText("");
    }//GEN-LAST:event_JBLimparActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        this.dispose(); //Fecha a janela
    }//GEN-LAST:event_JBSairActionPerformed

    private void JTFQuantidadeMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFQuantidadeMovimentacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFQuantidadeMovimentacaoActionPerformed

    private void JBRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRemoverActionPerformed
         try {
            String nomeProduto = JTFProdutoMovimentacao.getText().trim();
            if (nomeProduto.isEmpty()) {
                throw new IllegalArgumentException("Informe o nome do produto.");
            }

            Produto produto = produtoDAO.buscarPorNome(nomeProduto);
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado.");
            }

            int quantidade = Integer.parseInt(JTFQuantidadeMovimentacao.getText().trim());
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
            }

            int idProduto = produto.getIdProduto();
            Date data = Date.from(Instant.now());
            String tipoMovimentacao = "saida";
            MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
            movimentacao.setNomeProduto(nomeProduto);
            movimentacao.setIdProduto(idProduto);
            movimentacao.setDataMovimentacao(data);
            movimentacao.setQuantidadeMovimentada(quantidade);
            movimentacao.setTipoMovimentacao(tipoMovimentacao);
            movimentacaoDAO.cadastraMovimentacao(movimentacao);
            //movimentacaoDAO.inserirMovimentacao(idProduto, data, quantidade, nomeProduto, tipoMovimentacao);

            JOptionPane.showMessageDialog(null, "Movimentação de entrada registrada com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade válida.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_JBRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                MovimentacaoDAO movimentacaoDAO = null;
                new FrmMovimentacao(produtoDAO, movimentacaoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBRemover;
    private javax.swing.JButton JBSair;
    private javax.swing.JLabel JLCodigoMovimentacao;
    private javax.swing.JLabel JLMovimentacao;
    private javax.swing.JLabel JLProdutoMovimentacao;
    private javax.swing.JTextField JTFProdutoMovimentacao;
    private javax.swing.JTextField JTFQuantidadeMovimentacao;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
