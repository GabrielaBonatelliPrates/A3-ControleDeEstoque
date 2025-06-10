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
import dao.Conexao;
import dao.MovimentacaoDAO;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;
    private MovimentacaoDAO movimentacaoDAO;
    
    FrmRelatorios telaRelatorio = new FrmRelatorios(produtoDAO); //ainda vai adicionar implementação
    
    public FrmMenuPrincipal(ProdutoDAO produtoDAO, CategoriaDAO categoriaDAO, MovimentacaoDAO movimentacaoDAO) {
        initComponents();
       setSize(1920, 1080);
       setExtendedState(FrmMenuPrincipal.MAXIMIZED_BOTH);
       this.produtoDAO = produtoDAO;
       this.categoriaDAO = categoriaDAO;
       this.movimentacaoDAO = movimentacaoDAO;
       exibeStatus();
       editaJOption();

    }
    
    public void exibeStatus() {
        int numeroProdutos = produtoDAO.pegarProdutos().size(); //recebe o total de produtos (o tamanho da lista que pega os produtos presente no bd)
        int numeroCategorias = categoriaDAO.mostrarCategorias().size();  //recebe o total de categotorias (o tamanho da lista que pega as categorias presente no bd)
        String statusBD = ""; //declara o statusBD
        Connection connection = Conexao.conectar(); //atribui a conexão à classe que faz a conexão com o banco de dados
        if (connection != null) { //se o método conectar devolver algo que não é nul (ou seja, se contectar)
            statusBD = "Banco de Dados Conectado!";
        } else {
            statusBD = "Banco de Dados não conectado.";
        }
        String status = String.format( //status do estoque + da conexao mysql
                " Status Estoque\n"
                + "   Total de produtos cadastrados: %d\n"
                + "   Total de categorias cadastradas: %d\n"
                + "   Conexão MySQL: %s",
                numeroProdutos, numeroCategorias, statusBD
        );
        txtStatus.setText(status); //imprime o status no text area
    }

    //deixa os JOptionPanes da classe com formatação padrão (mais elegante visualmente) 
    public void editaJOption() {
        
        
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

        //define o icone como padrão
        UIManager.put("OptionPane.icon", icone);
        
        //define a fonte do JOption (pra utilizada na interface gráfica)
        Font novaFonte = new Font("Inter 18pt", Font.BOLD, 14);

        //aplica a nova fonte a vários componentes do JOptionPane
        UIManager.put("OptionPane.messageFont", novaFonte);
        UIManager.put("OptionPane.buttonFont", novaFonte);
        UIManager.put("OptionPane.messageForeground", Color.BLACK); //define a cor do texto
        UIManager.put("Button.background", Color.WHITE); //define a cor de fundo dos botões 
    }
    
    //cria mensagem formatada pro JOption Pane (showMessage)
    public void mensagem(String mensagem) {
        String titulo = "Controle de Estoque";
         ImageIcon icone = null;
        //url do icone para as mensagens
          URL url;
        try {
            url = new URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/caixa_logo_JOption.png"); //url do icone pro JOptionPane
            //icone para as mensagens
          icone = new ImageIcon(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE, icone); //JOptionPane formatado
    }
    
      public int mensagemOpcoes(String[] opcoes) {
        String titulo = "Controle de Estoque";
        String mensagem = "Escolha uma opção";
        ImageIcon icone = null;
        //url do icone para as mensagens
        URL url;
        try {
            url = new URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/caixa_logo_JOption.png"); //url do icone pro JOptionPane
            //icone para as mensagens
            icone = new ImageIcon(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return JOptionPane.showOptionDialog( //JOptionPane formatado
                null,
                mensagem,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icone,
                opcoes,
                opcoes[0]
        );
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLEstampa = new javax.swing.JLabel();
        btnMovimentacao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnGerenciamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStatus = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
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
        jMenuMovimentacoes = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuListarPrecos = new javax.swing.JMenuItem();
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
        setBackground(new java.awt.Color(255, 204, 204));
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

        JLEstampa.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/caixa_icone.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        btnMovimentacao.setFont(new java.awt.Font("Inter 18pt Light", 0, 14)); // NOI18N
        btnMovimentacao.setText("Adicionar Movimentação");
        btnMovimentacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimentacaoActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/caminhaozinho.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        jLabel5.setFont(new java.awt.Font("Inter 18pt", 0, 18)); // NOI18N
        jLabel5.setText("Atalhos");

        jLabel6.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/emite_relatorio_logo.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        btnRelatorio.setFont(new java.awt.Font("Inter 18pt Light", 0, 14)); // NOI18N
        btnRelatorio.setText("Relatórios");
        btnRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/cadastro_logo.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        btnCadastro.setFont(new java.awt.Font("Inter 18pt Light", 0, 14)); // NOI18N
        btnCadastro.setText("Cadastro");
        btnCadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/lapis_gerenciar.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        btnGerenciamento.setFont(new java.awt.Font("Inter 18pt Light", 0, 14)); // NOI18N
        btnGerenciamento.setText("Gerenciamento");
        btnGerenciamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGerenciamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciamentoActionPerformed(evt);
            }
        });

        txtStatus.setColumns(20);
        txtStatus.setFont(new java.awt.Font("Inter 18pt Light", 0, 20)); // NOI18N
        txtStatus.setRows(5);
        jScrollPane1.setViewportView(txtStatus);

        jLabel9.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://raw.githubusercontent.com/GabrielaBonatelliPrates/A3-ControleDeEstoque/main/src/resources/borda_marrom.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

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

        jMenuGerenciarProduto.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
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

        jMenuMovimentacoes.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuMovimentacoes.setText("Ver Movimentações");
        jMenuMovimentacoes.setToolTipText("");
        jMenuMovimentacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMovimentacoesActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuMovimentacoes);

        jMenuBar1.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Relatórios");
        jMenu5.setFont(new java.awt.Font("Inter 18pt Medium", 0, 14)); // NOI18N
        jMenu5.setMinimumSize(new java.awt.Dimension(80, 40));

        jMenuListarPrecos.setFont(new java.awt.Font("Inter 18pt", 0, 12)); // NOI18N
        jMenuListarPrecos.setText("Lista de preços");
        jMenuListarPrecos.setToolTipText("");
        jMenuListarPrecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarPrecosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuListarPrecos);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2944, 2944, 2944))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(248, 248, 248)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLEstampa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnGerenciamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(JLEstampa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGerenciamento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(38, 38, 38))
        );

        setSize(new java.awt.Dimension(1436, 955));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAcimaDaMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcimaDaMaximaActionPerformed
        //instancia a interface gráfica do relatório
        FrmEstoqueMaximo telaEstoqueMaximo = new FrmEstoqueMaximo(produtoDAO);
        //deixa ela vísível
        telaEstoqueMaximo.setVisible(true);
    }//GEN-LAST:event_jMenuAcimaDaMaximaActionPerformed

    private void jMenuListarPrecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarPrecosActionPerformed
       //instancia a interface gráfica do relatório
        FrmListaPrecos telaListaDePreco = new FrmListaPrecos(produtoDAO);
        telaListaDePreco.setVisible(true);
    }//GEN-LAST:event_jMenuListarPrecosActionPerformed

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
       FrmMovimentacao telaMovimentacao = new FrmMovimentacao(produtoDAO, movimentacaoDAO);
        telaMovimentacao.setVisible(true);
        //Ativação da tela de movimentação de estoque
    }//GEN-LAST:event_jMenuMovimentacaoActionPerformed

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
        FrmProdutoCategoria telaProdutoCategoria = new FrmProdutoCategoria(produtoDAO, categoriaDAO);
          telaProdutoCategoria.setVisible(true);      
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
        FrmGerenciarProduto telaGerenciar = new FrmGerenciarProduto(produtoDAO);
        //deixa ela vísível
        telaGerenciar.setVisible(true);
    }//GEN-LAST:event_jMenuGerenciarProdutoActionPerformed

    private void jMenuMovimentacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMovimentacoesActionPerformed
        FrmControleMovimentacao movimentacoes = new FrmControleMovimentacao(movimentacaoDAO);
         movimentacoes.setVisible(true);
    }//GEN-LAST:event_jMenuMovimentacoesActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
       FrmRelatorios telaRelatorios = new FrmRelatorios (produtoDAO);
       telaRelatorios.setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        String[] opcoes = {"Adicionar Produto", "Adicionar Categoria", "Voltar"}; //opções
        int escolha = mensagemOpcoes(opcoes); //manda pro metodo com JOptionPane 
        switch (escolha) {
            case 0:
                mensagem("Carregando...");
                FrmProdutoNovo telaCadastro = new FrmProdutoNovo(produtoDAO, categoriaDAO);
                telaCadastro.setVisible(true);
                break;
            case 1:
                mensagem("Carregando...");
                //instancia a interface gráfica do cadastro de categoria
                FrmCategoriaNova telaCategoria = new FrmCategoriaNova(produtoDAO, categoriaDAO);
                //deixa ela vísível
                telaCategoria.setVisible(true);
                break;
            case 2:
                mensagem("Voltando...");
                break;
            default:
                mensagem("Nenhuma opção selecionada.");
                break;
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentacaoActionPerformed
          String[] opcoes = {"Adicionar Movimentação", "Ver Movimentações", "Voltar"};
         int escolha = mensagemOpcoes(opcoes); //manda pro metodo com JOptionPane 
        switch (escolha) {
            case 0:
                mensagem("Carregando...");
              FrmMovimentacao telaMovimentacao = new FrmMovimentacao(produtoDAO, movimentacaoDAO);
        telaMovimentacao.setVisible(true);
        //Ativação da tela de movimentação de estoque
                break;
            case 1:
                mensagem("Carregando...");
                //instancia a interface gráfica de movimentacoes
                  FrmControleMovimentacao movimentacoes = new FrmControleMovimentacao(movimentacaoDAO);
                  //deixa ela visivel
         movimentacoes.setVisible(true);
                break;
            case 2:
                mensagem("Voltando...");
                break;
            default:
                mensagem("Nenhuma opção selecionada.");
                break;
        }
    }//GEN-LAST:event_btnMovimentacaoActionPerformed

    private void btnGerenciamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciamentoActionPerformed
        String[] opcoes = {"Gerenciar Produto", "Gerenciar Categoria", "Voltar"};
         int escolha = mensagemOpcoes(opcoes); //manda pro metodo com JOptionPane 
        switch (escolha) {
            case 0:
                mensagem("Carregando...");
              //instancia a interface gráfica do gerenciamento de  produto
        FrmGerenciarProduto telaGerenciar = new FrmGerenciarProduto(produtoDAO);
        //deixa ela vísível
        telaGerenciar.setVisible(true);
                break;
            case 1:
                mensagem("Carregando...");
                 //instancia a interface gráfica para gerenciar as categorias
        FrmGerenciarCategoria categoriaGerenciar = new FrmGerenciarCategoria(categoriaDAO);
        //deixa ela vísível
        categoriaGerenciar.setVisible(true);
                break;
            case 2:
                mensagem("Voltando...");
                break;
            default:
                mensagem("Nenhuma opção selecionada.");
                break;
        }
    }//GEN-LAST:event_btnGerenciamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLEstampa;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnGerenciamento;
    private javax.swing.JButton btnMovimentacao;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static final javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JMenuItem jMenuListarPrecos;
    private javax.swing.JMenuItem jMenuMovimentacao;
    private javax.swing.JMenuItem jMenuMovimentacoes;
    private javax.swing.JMenuItem jMenuNovoProduto;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuProdutosPorCategoria;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuSobre;
    private javax.swing.JMenuItem jMenuVerCategorias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtStatus;
    // End of variables declaration//GEN-END:variables
}
