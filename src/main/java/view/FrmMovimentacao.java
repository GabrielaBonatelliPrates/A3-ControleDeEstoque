package view;

import controller.MovimentacaoEstoque;
import dao.MovimentacaoDAO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controller.ExControleEstoque;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

public class FrmMovimentacao extends javax.swing.JFrame {
    private ProdutoDAO produtoDAO;
    private Produto produto;
    private MovimentacaoDAO movEst;
    private List<Produto> produtos = produtoDAO.pegarProdutos();

    public FrmMovimentacao(ProdutoDAO produtoDAO) {
        initComponents();
        this.produto = new Produto();
        this.produtoDAO = produtoDAO;

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

        jLabel3.setText("Codigo:");

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFQuantidadeMovimentacao)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLProdutoMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(JLCodigoMovimentacao)))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(JBLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBSair)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(JBAdicionar)
                        .addGap(26, 26, 26)
                        .addComponent(JBRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(JLMovimentacao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(JLMovimentacao)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLProdutoMovimentacao)
                    .addComponent(JTFProdutoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(JBRemover))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBLimpar)
                    .addComponent(JBSair))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
        MovimentacaoEstoque novaMov = new MovimentacaoEstoque();
        novaMov.setTipoMovimentacao("Adicao");
// criando variaveis para receber os valores/nomes da interface gráfica
        String nomeProduto = "";
        int codigo = 0;
        int quantidade = 0;

        try {

            //validando os dados.
            boolean acesso = false;
            while (acesso == false) {
                for (int i = 0; i < produtos.size(); i++) {

                    //Pegando o nome do Produto na Lista "produtos"
                    Produto x = produtos.get(i);
                    String y = x.getNomeProduto();

                    if (this.JTFProdutoMovimentacao.getText().trim().equalsIgnoreCase(y.trim())) {
                        codigo = x.getIdProduto();
                        this.JLCodigoMovimentacao.setText(String.valueOf(codigo));
                        acesso = true;
                    }
                }
                if (acesso == false) {
                    throw new Mensagem("Insira um produto ja existente");
                }
            }

            //Nome do produto
            if (this.JTFProdutoMovimentacao.getText().length() < 2) {
                throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");
            } else {
                nomeProduto = this.JTFProdutoMovimentacao.getText();
            }

            //Quantidade a ser alterada
            int x = Integer.parseInt(this.JTFQuantidadeMovimentacao.getText());
            if (x < 0) {
                throw new Mensagem("Quantidade deve ser um numero e maior que zero.");
            } else {
                quantidade = Integer.parseInt(this.JTFQuantidadeMovimentacao.getText());
            }

            //Verificando quantidade minima
            if (novaMov.movimentacaoEstoqueAdicao(codigo, quantidade) == false) {
                throw new Mensagem("Produto nao encontrado");
            }
            //Caso tudo estiver certo, dar baixa no estoque
            novaMov.movimentacaoEstoqueAdicao(codigo, quantidade);
            JOptionPane.showMessageDialog(null, "Baixa confirmada!");

            //Pegando as informações da movimentação
            novaMov.setData(Date.from(Instant.now()));
            novaMov.setNomeProduto(nomeProduto);
            novaMov.setQuantidadeMovimentada(quantidade);
            novaMov.setId(novaMov.gerarIdUnico());
            
            movEst.adicionarQuantidade(codigo, quantidade);

            try {
                //MovimentacaoEstoque.movimentacoes.add(novaMov);
                MovimentacaoDAO.inserirMovimentacao(novaMov.getId(), novaMov.getData(), novaMov.getQuantidadeMovimentada(), novaMov.getNomeProduto(), novaMov.getTipoMovimentacao());
            } catch (SQLException ex) {
                Logger.getLogger(FrmMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
            }

            produto.verificaMediaAbaixo();
            produto.verificaMediaAcima();
            if (produto.isAbaixoMedia()) {
                JOptionPane.showMessageDialog(null, "O produto esta abaixo da média");
            }
            if (produto.isAcimaMedia()) {
                JOptionPane.showMessageDialog(null, "O produto esta acima da média");
            }

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
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
        MovimentacaoEstoque novaMov = new MovimentacaoEstoque();
        novaMov.setTipoMovimentacao("Baixa");

// criando variaveis para receber os valores/nomes da interface gráfica
        String nomeProduto = "";
        int codigo = 0;
        int quantidade = 0;

        try {

            //validando os dados.
            boolean acesso = false;
            while (acesso == false) {
                for (int i = 0; i < produtos.size(); i++) {

                    //Pegando o nome do Produto na Lista "produtos"
                    Produto x = produtos.get(i);
                    String y = x.getNomeProduto();

                    if (this.JTFProdutoMovimentacao.getText().trim().equalsIgnoreCase(y.trim())) {
                        codigo = x.getIdProduto();
                        this.JLCodigoMovimentacao.setText(String.valueOf(codigo));
                        acesso = true;
                    }
                }
                if (acesso == false) {
                    throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");

                }
            }

            //Nome do produto
            if (this.JTFProdutoMovimentacao.getText().length() < 2) {
                throw new Mensagem("Nome do produto deve conter ao menos 2 caracteres.");
            } else {
                nomeProduto = this.JTFProdutoMovimentacao.getText();
            }

            //Quantidade a ser alterada
            int x = Integer.parseInt(this.JTFQuantidadeMovimentacao.getText());
            if (x < 0) {
                throw new Mensagem("Quantidade deve ser um numero e maior que zero.");
            } else {
                quantidade = Integer.parseInt(this.JTFQuantidadeMovimentacao.getText());
            }

            //Verificando quantidade minima
            if (novaMov.movimentacaoEstoqueReducao(codigo, quantidade) == false) {
                throw new Mensagem("Produto nao encontrado");
            }
            //Caso tudo estiver certo, dar baixa no estoque
            if (novaMov.movimentacaoEstoqueReducao(codigo, quantidade) == true) {
                JOptionPane.showMessageDialog(null, "Baixa confirmada!");

                //Pegando as informações da movimentação
                novaMov.setData(Date.from(Instant.now()));
                novaMov.setNomeProduto(nomeProduto);
                novaMov.setQuantidadeMovimentada(quantidade);
                novaMov.setId(novaMov.gerarIdUnico());
                
                movEst.retirarQuantidade(codigo, quantidade);

                try {
                    //MovimentacaoEstoque.movimentacoes.add(novaMov);
                    MovimentacaoDAO.inserirMovimentacao(novaMov.getId(), novaMov.getData(), novaMov.getQuantidadeMovimentada(), novaMov.getNomeProduto(), novaMov.getTipoMovimentacao());
                } catch (SQLException ex) {
                    Logger.getLogger(FrmMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
                }

                produto.verificaMediaAbaixo();
                produto.verificaMediaAcima();
                if (produto.isAbaixoMedia()) {
                    JOptionPane.showMessageDialog(null, "O produto esta abaixo da média");
                }
                if (produto.isAcimaMedia()) {
                    JOptionPane.showMessageDialog(null, "O produto esta acima da média");
                }
            }

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
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
                new FrmMovimentacao(produtoDAO).setVisible(true);
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
