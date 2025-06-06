package view;

import java.net.MalformedURLException;
import javax.swing.*;
import java.net.URL;
import javax.swing.ImageIcon;
import java.util.List;
import model.Produto;
import java.util.ArrayList;
import dao.ProdutoDAO;
import dao.CategoriaDAO;

public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    ProdutoDAO produtoDAO;
    CategoriaDAO categoriaDAO;
    
    FrmRelatorios telaRelatorio = new FrmRelatorios(produtoDAO); //ainda vai adicionar implementação
    
    public FrmMenuPrincipal(ProdutoDAO produtoDAO, CategoriaDAO categoriaDAO) {
        initComponents();
       setSize(1920, 1080);
       setExtendedState(FrmMenuPrincipal.MAXIMIZED_BOTH);
       this.produtoDAO = produtoDAO;
       this.categoriaDAO = categoriaDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCampoPesquisa = new javax.swing.JTextField();
        txtFicha = new java.awt.TextArea();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JLEstampa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSobre = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuNovoProduto = new javax.swing.JMenuItem();
        jMenuGerenciarProduto = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuAdicionarCategoria = new javax.swing.JMenuItem();
        jMenuGerenciaCategoria = new javax.swing.JMenuItem();
        jMenuVerCategorias = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuMovimentacao = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuListarProecos = new javax.swing.JMenuItem();
        jMenuBalancoFinanceiro = new javax.swing.JMenuItem();
        jMenuProdutosPorCategoria = new javax.swing.JMenuItem();
        jMenuAbaixoDaMinima = new javax.swing.JMenuItem();
        jMenuAcimaDaMaxima = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estoque");
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1436, 955));

        jLabel3.setToolTipText("");
        jLabel3.setName(""); // NOI18N

        jLabel2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/titulo_menu.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        txtCampoPesquisa.setFont(new java.awt.Font("Inter 18pt", 0, 23)); // NOI18N

        txtFicha.setFont(new java.awt.Font("Inter 18pt Light", 0, 20)); // NOI18N

        btnPesquisar.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/lupa_pesquisa.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        btnPesquisar.setMinimumSize(new java.awt.Dimension(48, 48));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Inter 18pt Medium", 0, 30)); // NOI18N
        jLabel5.setText("Ficha Produto");

        jMenuBar1.setBackground(new java.awt.Color(156, 73, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(400, 50));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Arquivo");
        jMenu1.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(80, 40));

        jMenuSobre.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuSobre.setText("Sobre");
        jMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSobreActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSobre);

        jMenuSair.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Produtos");
        jMenu2.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(80, 40));

        jMenuNovoProduto.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuNovoProduto.setText("Adicionar Produto");
        jMenuNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNovoProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuNovoProduto);

        jMenuGerenciarProduto.setText("Gerenciar Produto");
        jMenuGerenciarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuGerenciarProduto);

        jMenuProdutos.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuProdutos.setText("Ver Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuProdutos);

        jMenuBar1.add(jMenu2);

        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setText("Categorias");
        jMenu6.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu6.setMaximumSize(new java.awt.Dimension(100, 40));
        jMenu6.setMinimumSize(new java.awt.Dimension(100, 40));
        jMenu6.setPreferredSize(new java.awt.Dimension(80, 40));

        jMenuAdicionarCategoria.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuAdicionarCategoria.setText("Adicionar Categoria");
        jMenuAdicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdicionarCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuAdicionarCategoria);

        jMenuGerenciaCategoria.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuGerenciaCategoria.setText("Gerenciar Categoria");
        jMenuGerenciaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciaCategoriaActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuGerenciaCategoria);

        jMenuVerCategorias.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuVerCategorias.setText("Ver Categorias");
        jMenuVerCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerCategoriasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuVerCategorias);

        jMenuBar1.add(jMenu6);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Estoque");
        jMenu4.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu4.setMaximumSize(new java.awt.Dimension(80, 40));
        jMenu4.setMinimumSize(new java.awt.Dimension(80, 40));
        jMenu4.setPreferredSize(new java.awt.Dimension(80, 40));

        jMenuMovimentacao.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuMovimentacao.setText("Adicionar Movimentação");
        jMenuMovimentacao.setToolTipText("");
        jMenuMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMovimentacaoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuMovimentacao);

        jMenuBar1.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Relatórios");
        jMenu5.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu5.setMinimumSize(new java.awt.Dimension(80, 40));

        jMenuListarProecos.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuListarProecos.setText("Lista de preços");
        jMenuListarProecos.setToolTipText("");
        jMenuListarProecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarProecosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuListarProecos);

        jMenuBalancoFinanceiro.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuBalancoFinanceiro.setText("Balanço financeiro");
        jMenuBalancoFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBalancoFinanceiroActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuBalancoFinanceiro);

        jMenuProdutosPorCategoria.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuProdutosPorCategoria.setText("Produto por categoria");
        jMenuProdutosPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosPorCategoriaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuProdutosPorCategoria);

        jMenuAbaixoDaMinima.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuAbaixoDaMinima.setText("Produtos abaixo da quantidade mínima");
        jMenuAbaixoDaMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAbaixoDaMinimaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuAbaixoDaMinima);

        jMenuAcimaDaMaxima.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuAcimaDaMaxima.setText("Produtos acima da quantidade máxima");
        jMenuAcimaDaMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcimaDaMaximaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuAcimaDaMaxima);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(JLEstampa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(237, 237, 237))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(JLEstampa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(495, 495, 495))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAcimaDaMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcimaDaMaximaActionPerformed
        //instancia a interface gráfica do relatório
        FrmEstoqueMaximo telaEstoqueMaximo = new FrmEstoqueMaximo(produtoDAO);
        //deixa ela vísível
        telaEstoqueMaximo.setVisible(true);
    }//GEN-LAST:event_jMenuAcimaDaMaximaActionPerformed

    private void jMenuListarProecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarProecosActionPerformed
       //instancia a interface gráfica do relatório
        FrmListaPrecos telaListaDePreco = new FrmListaPrecos(produtoDAO);
    }//GEN-LAST:event_jMenuListarProecosActionPerformed

    private void jMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSobreActionPerformed
        //instancia a interface gráfica do sobre
        FrmSobre telaSobre = new FrmSobre();
        //deixa ela vísível
        telaSobre.setVisible(true);
        
    }//GEN-LAST:event_jMenuSobreActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        //encerra o programa
        System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNovoProdutoActionPerformed
       FrmProdutoNovo telaCadastro = new FrmProdutoNovo(produtoDAO, categoriaDAO);
        telaCadastro.setVisible(true);
        //Ativação da tela de cadastro de Produto

    }//GEN-LAST:event_jMenuNovoProdutoActionPerformed

    private void jMenuMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMovimentacaoActionPerformed
        FrmMovimentacao telaMovimentacao = new FrmMovimentacao(produtoDAO);
        telaMovimentacao.setVisible(true);
        //Ativação da tela de movimentação de estoque
    }//GEN-LAST:event_jMenuMovimentacaoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
/*
        String nomeProduto = txtCampoPesquisa.getText();
        String dadosProduto = "";
        if (!telaCadastro.produtos.isEmpty()) {
            boolean encontrado = false;
            for (int i = 0; i < telaCadastro.produtos.size(); i++) {
                Produto produtoProcurado = telaCadastro.produtos.get(i);
                if (produtoProcurado.getNomeProduto().equals(nomeProduto.trim())) {
                    dadosProduto = String.format("Nome: %s\nID: %s\nPreço unitário: %s\nUnidade de medida: %s\nQuantidades em estoque: %s\nQuantidade mínima: %s\nQuantidade máxima: %s\nCategoria: %s\n",
                            produtoProcurado.getNomeProduto(),
                            produtoProcurado.getIdProduto(),
                            produtoProcurado.getPrecoUnit(),
                            produtoProcurado.getUnidadeProduto(),
                            produtoProcurado.getQuantidadeEstoque(),
                            produtoProcurado.getEstoqueMinimo(),
                            produtoProcurado.getEstoqueMaximo(),
                            produtoProcurado.getCategoria());
                    encontrado = true;
                    break;
                }
            }
            txtFicha.setText(dadosProduto);
        } */
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jMenuBalancoFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBalancoFinanceiroActionPerformed
       //instancia a interface gráfica do balanço financeiro
        FrmBalancoFinanceiro balancoFinanceiro = new FrmBalancoFinanceiro(produtoDAO);
        //deixa ela vísível
        balancoFinanceiro.setVisible(true);
    }//GEN-LAST:event_jMenuBalancoFinanceiroActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        //instancia a interface gráfica dos produtos
        FrmProdutos produtos = new FrmProdutos(produtoDAO);
         //deixa ela vísível
        produtos.setVisible(true);
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuAbaixoDaMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAbaixoDaMinimaActionPerformed
         //instancia a interface gráfica do relatório
        FrmEstoqueMinimo telaEstoqueMinimo = new FrmEstoqueMinimo(produtoDAO);
        //deixa ela vísível
        telaEstoqueMinimo.setVisible(true);
       
    }//GEN-LAST:event_jMenuAbaixoDaMinimaActionPerformed

    private void jMenuProdutosPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosPorCategoriaActionPerformed
        
    }//GEN-LAST:event_jMenuProdutosPorCategoriaActionPerformed

    private void jMenuAdicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdicionarCategoriaActionPerformed
       //instancia a interface gráfica do cadastro de categoria
        FrmCategoriaNova telaCategoria = new FrmCategoriaNova(produtoDAO, categoriaDAO);
        //deixa ela vísível
       telaCategoria.setVisible(true);
    }//GEN-LAST:event_jMenuAdicionarCategoriaActionPerformed

    private void jMenuGerenciaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciaCategoriaActionPerformed
        //instancia a interface gráfica para gerenciar as categorias
        FrmGerenciarCategoria categoriaGerenciar = new FrmGerenciarCategoria(categoriaDAO);
        //deixa ela vísível
        categoriaGerenciar.setVisible(true);
    }//GEN-LAST:event_jMenuGerenciaCategoriaActionPerformed

    private void jMenuVerCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerCategoriasActionPerformed
       //instancia a interface gráfica das categorias
        FrmCategorias categorias = new FrmCategorias(categoriaDAO);
        //deixa ela vísível
        categorias.setVisible(true);
    }//GEN-LAST:event_jMenuVerCategoriasActionPerformed

    private void jMenuGerenciarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarProdutoActionPerformed
        //instancia a interface gráfica do gerenciamento de  produto
        FrmGerenciarProduto telaGerenciar = new FrmGerenciarProduto();
        //deixa ela vísível
        telaGerenciar.setVisible(true);
    }//GEN-LAST:event_jMenuGerenciarProdutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLEstampa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuAbaixoDaMinima;
    private javax.swing.JMenuItem jMenuAcimaDaMaxima;
    private javax.swing.JMenuItem jMenuAdicionarCategoria;
    private javax.swing.JMenuItem jMenuBalancoFinanceiro;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuGerenciaCategoria;
    private javax.swing.JMenuItem jMenuGerenciarProduto;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuListarProecos;
    private javax.swing.JMenuItem jMenuMovimentacao;
    private javax.swing.JMenuItem jMenuNovoProduto;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuProdutosPorCategoria;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuSobre;
    private javax.swing.JMenuItem jMenuVerCategorias;
    private javax.swing.JTextField txtCampoPesquisa;
    private java.awt.TextArea txtFicha;
    // End of variables declaration//GEN-END:variables
}
