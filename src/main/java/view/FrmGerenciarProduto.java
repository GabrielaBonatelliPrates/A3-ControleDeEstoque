package view;

import dao.CategoriaDAO;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

/** FrmGerenciarProduto é um JFrame para atualizar e excluir produtos, além de reajustar os preços percentualmente
 *
 * @author GabrielaBonatelliPrates
 */
public class FrmGerenciarProduto extends javax.swing.JFrame {

    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    /**
     *
     * @param produtoDAO valor inicial de produtoDAO
     * @param categoriaDAO valor inicial de categoriaDAO
     */
    public FrmGerenciarProduto(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
        this.categoriaDAO = new CategoriaDAO();
        initComponents();
        this.mostrarTabela();
        this.mostrarCategorias();
        setExtendedState(FrmGerenciarProduto.MAXIMIZED_BOTH);
    }

    /**
     *Método que carrega na table todos os produtos cadastrados 
     */
    public void mostrarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableGerenciaProdutos.getModel(); // para manipular a tabela 
        modelo.setNumRows(0); //limpa as linhas do modelo da tabela
        List<Produto> listaProdutos = produtoDAO.pegarProdutos(); //pega todos os produtos do banco de dados
        for (Produto p : listaProdutos) { //passa por todos os produtos e cria as linhas da tabela com os dados solicitados
            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNomeProduto(),
                p.getPrecoUnit(),
                p.getUnidadeProduto(),
                p.getQuantidadeEstoque(),
                p.getEstoqueMinimo(),
                p.getEstoqueMaximo(),
                p.getCategoria().getNomeCategoria(),
                p.getCategoria().getTamanho(),
                p.getCategoria().getEmbalagem()
            });
        }
    }

    /**
     * Método que carrega na combo box todas as categorias cadastradas
     */
    public void mostrarCategorias() {
        //Cria um ArrayList para mostrar os nomes das categorias cadastrados no banco de dados
        List<Categoria> mostrarCategorias = categoriaDAO.mostrarCategorias();

        jComboBoxCategoria.removeAllItems(); //limpa itens anteriores para evitar erros

        if (mostrarCategorias.isEmpty()) { //Caso não tenha nenhuma categoria cadastrada vai criar uma categoria informativa
            jComboBoxCategoria.addItem(new Categoria(0, "Nenhuma categoria cadastrada", "", ""));
            jComboBoxCategoria.setEnabled(false);
        } else {
            for (Categoria categoria : mostrarCategorias) {
                jComboBoxCategoria.addItem(categoria); //Adiciona na ComboBox as categorias já cadastradas
            }
            jComboBoxCategoria.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGerenciaProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTFNomeProduto = new javax.swing.JTextField();
        JTFPrecoUnit = new javax.swing.JTextField();
        JTFUnidadeProduto = new javax.swing.JTextField();
        JTFQuantidadeEstoque = new javax.swing.JTextField();
        JTFEstoqueMinimo = new javax.swing.JTextField();
        JTFEstoqueMaximo = new javax.swing.JTextField();
        JBAtualizarProduto = new javax.swing.JButton();
        JBExcluirProduto = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JBReajustarProduto = new javax.swing.JButton();
        JTFProdutoNovoPreco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        JTFAumentoPercentualProduto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JRBAumento = new javax.swing.JRadioButton();
        JRBDesconto = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        JBReajustarEstoque = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JTFAumentoPercentualEstoque = new javax.swing.JTextField();
        JRBAumento1 = new javax.swing.JRadioButton();
        JRBDesconto1 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        JBLimpar = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1436, 955));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Gerenciar Produto");

        jTableGerenciaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço unitário", "Unidade", "Quantidade em estoque", "Estoque mínimo", "Estoque máximo", "Nome da categoria", "Tamanho", "Embalagem"
            }
        ));
        jTableGerenciaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGerenciaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGerenciaProdutos);

        jLabel2.setText("Nome:");

        jLabel4.setText("Preço unitário:");

        jLabel5.setText("Unidade:");

        jLabel6.setText("Quantidade em estoque:");

        jLabel7.setText("Estoque mínimo:");

        jLabel8.setText("Estoque máximo:");

        jLabel9.setText("Categoria:");

        JTFUnidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFUnidadeProdutoActionPerformed(evt);
            }
        });

        JBAtualizarProduto.setText("Atualizar informações");
        JBAtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAtualizarProdutoActionPerformed(evt);
            }
        });

        JBExcluirProduto.setText("Excluir produto");
        JBExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirProdutoActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(146, 110, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Reajuste de preços por produto:");

        JBReajustarProduto.setText("Reajustar");
        JBReajustarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReajustarProdutoActionPerformed(evt);
            }
        });

        jLabel13.setText("Reajuste percentual de:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("%");

        jLabel15.setText("Produto:");

        buttonGroup1.add(JRBAumento);
        JRBAumento.setText("Aumento");

        buttonGroup1.add(JRBDesconto);
        JRBDesconto.setText("Desconto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFAumentoPercentualProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(JRBAumento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JRBDesconto))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFProdutoNovoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(JBReajustarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFProdutoNovoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(JTFAumentoPercentualProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRBAumento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JRBDesconto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBReajustarProduto)
                .addGap(32, 32, 32))
        );

        jPanel2.setBackground(new java.awt.Color(146, 110, 80));

        JBReajustarEstoque.setText("Reajustar");
        JBReajustarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReajustarEstoqueActionPerformed(evt);
            }
        });

        jLabel19.setText("Reajuste percentual de:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("%");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Reajuste de preços do estoque:");

        buttonGroup2.add(JRBAumento1);
        JRBAumento1.setText("Aumento");

        buttonGroup2.add(JRBDesconto1);
        JRBDesconto1.setText("Desconto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JBReajustarEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(JTFAumentoPercentualEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20))
                                    .addComponent(jLabel19))
                                .addGap(65, 65, 65))
                            .addComponent(jLabel16))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JRBAumento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRBDesconto1)
                        .addGap(32, 32, 32))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel16)
                .addGap(39, 39, 39)
                .addComponent(jLabel19)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(JTFAumentoPercentualEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBAumento1)
                    .addComponent(JRBDesconto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBReajustarEstoque)
                .addGap(45, 45, 45))
        );

        jLabel12.setIcon(new javax.swing.JLabel() {
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
        jLabel12.setText("jLabel12");

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(JTFEstoqueMaximo))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFEstoqueMinimo))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFQuantidadeEstoque))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFUnidadeProduto))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFPrecoUnit))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JTFNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(JBLimpar)))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBAtualizarProduto)
                                        .addGap(105, 105, 105)
                                        .addComponent(JBExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(514, 514, 514)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTFNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTFPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JTFUnidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JTFQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JTFEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(JTFEstoqueMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(JBLimpar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBAtualizarProduto)
                            .addComponent(JBExcluirProduto)
                            .addComponent(JBVoltar))
                        .addGap(44, 44, 44))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose(); //Fecha esse frame
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JTFUnidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFUnidadeProdutoActionPerformed

    }//GEN-LAST:event_JTFUnidadeProdutoActionPerformed

    
/** método para reajustar o preco dos produtos com base em uma porcentagem pedida
 *
 * @author Davi-Wolff
 */
    private void JBReajustarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReajustarProdutoActionPerformed
        List<Produto> listaProdutos = produtoDAO.pegarProdutos();
        try {
            for (Produto produto : listaProdutos) { //cria um objeto Produto que passará por toda a lista "listaProdutos" que possui todos os produtos
                if (produto.getNomeProduto().equals(JTFProdutoNovoPreco.getText())) { //quando o nome do produto for igual a um outro nome da lista
                    double precoAtual = produto.getPrecoUnit(); //pega o preço do produto
                    double percentual = Double.parseDouble(JTFAumentoPercentualProduto.getText());  //pega a porcentagem a ser aumentada/diminuida
                    double precoNovo = 0;

                    if (JRBAumento.isSelected()) {  //se o botão de aumentar for selecionado
                        precoNovo = precoAtual * (1 + percentual / 100);    //calculo para ajustar o preço de acordo com a porcentagem nova
                    } else if (JRBDesconto.isSelected()) {  //se o botão de reduzir for selecionado
                        precoNovo = precoAtual * (1 - percentual / 100);    //calculo para ajustar o preço de acordo com a porcentagem nova
                    } else {
                        throw new Mensagem("Selecione o reajuste a ser efetivado.");    //Mesagem gerada ao não selecionar nenhum botão
                    }

                    produto.setPrecoUnit(precoNovo);    //insere o novo preço nos produtos
                    produtoDAO.atualizarPreco(produto.getNomeProduto(), produto.getPrecoUnit(), produto.getIdProduto());    //insere o novo preço nos produtos no banco de dados

                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos.");
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_JBReajustarProdutoActionPerformed

/** método para reajustar o preco dos produtos com base em uma porcentagem pedida
 *
 * @author Davi-Wolff
 */
    private void JBReajustarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReajustarEstoqueActionPerformed
        List<Produto> listaProdutos = produtoDAO.pegarProdutos();

        try {
            for (Produto produto : listaProdutos) { //cria um objeto Produto que passará por toda a lista "listaProdutos" que possui todos os produtos
                double precoAtual = produto.getPrecoUnit(); //pega o preço do produto
                double percentual = Double.parseDouble(JTFAumentoPercentualEstoque.getText()); //pega a porcentagem a ser aumentada/diminuida
                double precoNovo = 0.0;

                if (JRBAumento1.isSelected()) { //se o botão de aumentar for selecionado
                    precoNovo = precoAtual * (1 + (percentual / 100));   //calculo para ajustar o preço de acordo com a porcentagem nova
                } else if (JRBDesconto1.isSelected()) { //se o botão de reduzir for selecionado
                    precoNovo = precoAtual * (1 - (percentual / 100));  //calculo para ajustar o preço de acordo com a porcentagem nova
                } else {
                    throw new Mensagem("Selecione o reajuste a ser efetivado.");    //Mesagem gerada ao não selecionar nenhum botão
                }

                produto.setPrecoUnit(precoNovo);    //insere o novo preço nos produtos
                produtoDAO.atualizarPreco(produto.getNomeProduto(), produto.getPrecoUnit(), produto.getIdProduto());     //insere o novo preço nos produtos no banco de dados
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos.");
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_JBReajustarEstoqueActionPerformed

/** método para mostrar as informações do produto para poderem ser alteradas ao clicar em um produto na tabela 
 *
 * @author GabrielaBonatelliPrates
 */
    private void jTableGerenciaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGerenciaProdutosMouseClicked
        //Evento para fazer os dados completarem os Text Field e a Combo Box quando clicar em um produto da tabela
        if (this.jTableGerenciaProdutos.getSelectedRow() != -1) {
            String nome = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 1).toString();
            String precoUnit = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 2).toString();
            String unidadeProduto = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 3).toString();
            String quantidadeEstoque = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 4).toString();
            String estoqueMinimo = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 5).toString();
            String estoqueMaximo = this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 6).toString();

            this.JTFNomeProduto.setText(nome);
            this.JTFPrecoUnit.setText(precoUnit);
            this.JTFUnidadeProduto.setText(unidadeProduto);
            this.JTFQuantidadeEstoque.setText(quantidadeEstoque);
            this.JTFEstoqueMinimo.setText(estoqueMinimo);
            this.JTFEstoqueMaximo.setText(estoqueMaximo);

            String categoriaSelecionada = jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 7).toString(); //Pega o nome da categoria selecionada 
            for (int i = 0; i < jComboBoxCategoria.getItemCount(); i++) { //passa por todas as categorias da combo box para poder achar a procurada
                Categoria categoria = (Categoria) jComboBoxCategoria.getItemAt(i); //converte para a combo box pegar um objeto Categoria
                if (categoria.getNomeCategoria().equalsIgnoreCase(categoriaSelecionada)) { //Compara se o nome da categoria na tabela é igual ao da combo box e seleciona o que for
                    jComboBoxCategoria.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jTableGerenciaProdutosMouseClicked

/** método para atualizar dados de um determinado produto selecionado
 *
 * @author GabrielaBonatelliPrates
 */
    private void JBAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAtualizarProdutoActionPerformed
        try {
            
            //Criando variaveis para pegar os dados
            int idProduto = 0;
            String nomeProduto = "";
            double precoUnit = 0.00;
            String unidadeProduto = "";
            int quantidadeEstoque = 0;
            int estoqueMinimo = 0;
            int estoqueMaximo = 0;
            
            //Checando erros em:
            // Atualizar nome do produto
            if (this.JTFNomeProduto.getText().length() < 2) {
                throw new Mensagem(" O nome do produto deve conter ao menos 2 caracteres.");
            } else {
                nomeProduto = this.JTFNomeProduto.getText();
            }

            // Atualizar o preço unitário do produto
            double x = Double.parseDouble(this.JTFPrecoUnit.getText());
            if (x <= 0) {
                throw new Mensagem(" O valor do produto deve ser maior que zero.");
            }
            if (this.JTFPrecoUnit.getText().length() <= 0) {
                throw new Mensagem(" O valor do produto deve ser maior que zero.");
            } else {
                precoUnit = Double.parseDouble(this.JTFPrecoUnit.getText());
            }

            //Atualizar unidade do produto
            if (this.JTFUnidadeProduto.getText().length() < 1) {
                throw new Mensagem(" A unidade do produto deve conter ao menos 1 caractere.");
            } else {
                unidadeProduto = this.JTFUnidadeProduto.getText();
            }

            //Atualizar quantidade no estoque do produto
            int y = Integer.parseInt(this.JTFQuantidadeEstoque.getText());
            if (y <= 0) {
                throw new Mensagem(" A quantidade de produto em estoque deve ser maior que zero.");
            }
            if (this.JTFQuantidadeEstoque.getText().length() <= 0) {
                throw new Mensagem(" A quantidade de produto em estoque deve ser maior que zero.");
            } else {
                quantidadeEstoque = Integer.parseInt(this.JTFQuantidadeEstoque.getText());
            }

            //Atualizar quantidade mínima necessária do produto
            y = Integer.parseInt(this.JTFEstoqueMinimo.getText());
            if (y <= 0) {
                throw new Mensagem(" A quantidade mínima de produto em estoque deve ser maior que zero.");
            } else {
                estoqueMinimo = y;
            }
            if (this.JTFEstoqueMinimo.getText().length() <= 0) {
                throw new Mensagem(" A quantidade mínima de produto em estoque deve ser maior que zero.");
            } else {
                estoqueMinimo = Integer.parseInt(this.JTFEstoqueMinimo.getText());
            }

            //Atualizar quantidade máxima necessária do produto
            y = Integer.parseInt(this.JTFEstoqueMaximo.getText());
            if (y <= 0) {
                throw new Mensagem(" A quantidade máxima de produto em estoque deve ser maior que zero.");
            } else {
                estoqueMaximo = y;
            }

            if (this.JTFEstoqueMaximo.getText().length() <= 0) {
                throw new Mensagem(" A quantidade máxima de produto em estoque deve ser maior que zero.");
            } else {
                estoqueMaximo = Integer.parseInt(this.JTFEstoqueMaximo.getText());
            }

            //Para garantir que tenha um produto selecionado na hora de alterar os dados
            if (this.jTableGerenciaProdutos.getSelectedRow() == -1) {
                throw new Mensagem("Você precisa selecionar um produto para poder alterá-lo");
            } else {
                idProduto = Integer.parseInt(this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 0).toString());
            }

            //Procura a categoria selecionada na combo box e atualiza os dados de acordo com ela
            Categoria categoriaSelecionada = (Categoria) jComboBoxCategoria.getSelectedItem();
            String nomeCategoria = categoriaSelecionada.getNomeCategoria();
            String tamanho = categoriaSelecionada.getTamanho();
            String embalagem = categoriaSelecionada.getEmbalagem();

            //Atualiza o produto e limpa os campos
            if (produtoDAO.atualizarProdutoBD(idProduto, nomeProduto, precoUnit, unidadeProduto, quantidadeEstoque, estoqueMinimo,
                    estoqueMaximo, nomeCategoria, tamanho, embalagem)) {
                this.JTFNomeProduto.setText("");
                this.JTFPrecoUnit.setText("");
                this.JTFUnidadeProduto.setText("");
                this.JTFQuantidadeEstoque.setText("");
                this.JTFEstoqueMinimo.setText("");
                this.JTFEstoqueMaximo.setText("");
                JOptionPane.showMessageDialog(null, "Produto atualizado");
            }

            // Caso aconteça algum erro:
        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao converter número: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        } //Vai atualizar a tabela
        finally {
            mostrarTabela();
        }

    }//GEN-LAST:event_JBAtualizarProdutoActionPerformed

/** método para excluir um determinado produto
 *
 * @author GabrielaBonatelliPrates
 */
    private void JBExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirProdutoActionPerformed
        try {
            int idProduto = 0; // variável para armazenar o ID excluído

            //Para garantir que tenha um produto selecionado na hora de alterar os dados
            if (this.jTableGerenciaProdutos.getSelectedRow() == -1) {
                throw new Mensagem("Você precisa selecionar um produto para poder alterá-lo");
            } else {
                idProduto = Integer.parseInt(this.jTableGerenciaProdutos.getValueAt(this.jTableGerenciaProdutos.getSelectedRow(), 0).toString());
            }

            //Garantir que o usuário quer apagar o produto
            String[] confirmacao = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null, "Quer excluir o produto?", "Confirmação",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, confirmacao, confirmacao[0]);

            //Limpar os campos caso o usuário aperte sim
            if (resposta == 0) {
                if (produtoDAO.deletarProdutoBD(idProduto)) {
                    this.JTFNomeProduto.setText("");
                    this.JTFPrecoUnit.setText("");
                    this.JTFUnidadeProduto.setText("");
                    this.JTFQuantidadeEstoque.setText("");
                    this.JTFEstoqueMinimo.setText("");
                    this.JTFEstoqueMaximo.setText("");
                    JOptionPane.showMessageDialog(null, "Produto excluído");
                }
            }
        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            mostrarTabela();
        }
    }//GEN-LAST:event_JBExcluirProdutoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.mostrarTabela(); 
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.mostrarTabela();
    }//GEN-LAST:event_formWindowOpened

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        this.JTFNomeProduto.setText("");
        this.JTFPrecoUnit.setText("");
        this.JTFUnidadeProduto.setText("");
        this.JTFQuantidadeEstoque.setText("");
        this.JTFEstoqueMinimo.setText("");
        this.JTFEstoqueMaximo.setText("");
    }//GEN-LAST:event_JBLimparActionPerformed

    /**
     *
     * @param args metodo principal do FrmGerenciarProduto
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
            java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutoDAO produtoDAO = null;
                new FrmGerenciarProduto(produtoDAO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAtualizarProduto;
    private javax.swing.JButton JBExcluirProduto;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBReajustarEstoque;
    private javax.swing.JButton JBReajustarProduto;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JRadioButton JRBAumento;
    private javax.swing.JRadioButton JRBAumento1;
    private javax.swing.JRadioButton JRBDesconto;
    private javax.swing.JRadioButton JRBDesconto1;
    private javax.swing.JTextField JTFAumentoPercentualEstoque;
    private javax.swing.JTextField JTFAumentoPercentualProduto;
    private javax.swing.JTextField JTFEstoqueMaximo;
    private javax.swing.JTextField JTFEstoqueMinimo;
    private javax.swing.JTextField JTFNomeProduto;
    private javax.swing.JTextField JTFPrecoUnit;
    private javax.swing.JTextField JTFProdutoNovoPreco;
    private javax.swing.JTextField JTFQuantidadeEstoque;
    private javax.swing.JTextField JTFUnidadeProduto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGerenciaProdutos;
    // End of variables declaration//GEN-END:variables
}
