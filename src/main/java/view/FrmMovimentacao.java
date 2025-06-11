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
 * @author Estermrn
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
     * @param movimentacaoDAO valor inicial do movimentacaoDAO
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
        jLabel4 = new javax.swing.JLabel();
        JBAdicionar = new javax.swing.JButton();
        JBRemover = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        JTFQuantidadeMovimentacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Estoque");
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);

        JLMovimentacao.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        JLMovimentacao.setText("Movimentação");

        JLProdutoMovimentacao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLProdutoMovimentacao.setText("Produto:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Quantidade:");

        JBAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBAdicionar.setText("Adicionar");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        JBRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBRemover.setText("Remover");
        JBRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRemoverActionPerformed(evt);
            }
        });

        JBLimpar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JBAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLMovimentacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTFQuantidadeMovimentacao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLProdutoMovimentacao)
                                        .addGap(52, 52, 52)
                                        .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))))
                .addContainerGap(485, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(JLMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLProdutoMovimentacao))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTFQuantidadeMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JBLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addComponent(JBAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addComponent(JBRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(332, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1436, 957);
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
    private javax.swing.JLabel JLMovimentacao;
    private javax.swing.JLabel JLProdutoMovimentacao;
    private javax.swing.JTextField JTFProdutoMovimentacao;
    private javax.swing.JTextField JTFQuantidadeMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
