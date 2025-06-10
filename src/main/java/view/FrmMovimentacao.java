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

/** FrmMovimentacao é um JFrame que da update na quantidade dos produtos no estoque.
 *
 * @author Davi-Wolff
 */

public class FrmMovimentacao extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private Produto produto;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Produto> produtos;

    /**
     *
     * @param produtoDAO valor inicial do produtoDAO
     * @param movimentacaoDAO   valor inicial do movimentacaoDAO
     */
    public FrmMovimentacao(ProdutoDAO produtoDAO, MovimentacaoDAO movimentacaoDAO) {
        initComponents();
        this.produto = new Produto();
        this.produtoDAO = produtoDAO;
        this.movimentacaoDAO = movimentacaoDAO;
        this.produtos = produtoDAO.pegarProdutos(); 
        setExtendedState(FrmMovimentacao.MAXIMIZED_BOTH);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Estoque");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);

        JLMovimentacao.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        JLMovimentacao.setText("Movimentação");

        JLProdutoMovimentacao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLProdutoMovimentacao.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Id:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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

        JLCodigoMovimentacao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLCodigoMovimentacao.setText("0");

        jLabel1.setText("jLabel1");

        jLabel5.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBLimpar)
                                .addGap(165, 165, 165)
                                .addComponent(JBAdicionar)
                                .addGap(142, 142, 142)
                                .addComponent(JBRemover)
                                .addGap(148, 148, 148)
                                .addComponent(JBSair))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLProdutoMovimentacao))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLCodigoMovimentacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(JLMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFQuantidadeMovimentacao)))))
                        .addGap(549, 549, 549))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(JLMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLProdutoMovimentacao))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLCodigoMovimentacao)
                            .addComponent(jLabel3))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JTFQuantidadeMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSair)
                    .addComponent(JBRemover)
                    .addComponent(JBAdicionar)
                    .addComponent(JBLimpar))
                .addGap(191, 191, 191))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
 try {
            //checando se há erros ou falta de informação
            
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

            int idProduto = produto.getIdProduto(); //pegando o id do produto
            Date data = Date.from(Instant.now());   //pegando o momento da movimentação
            String tipoMovimentacao = "entrada";    //inserindo qual o tipo de movimentação
            MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();  //instanciando nova movimentação para 
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

    /**
     *
     * @param args metodo principal do FrmMoviemntacao
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
