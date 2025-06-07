package view;

import dao.CategoriaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;
import dao.ProdutoDAO;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class FrmProdutoNovo extends javax.swing.JFrame {
private ProdutoDAO produtoDAO;
private CategoriaDAO categoriaDAO;

    
    public FrmProdutoNovo(ProdutoDAO produtoDAO, CategoriaDAO categoriaDAO) {
        this.produtoDAO = produtoDAO;
        this.categoriaDAO = categoriaDAO;
        initComponents();
       mostrarCategorias();
    }
    
    public void mostrarCategorias(){
        //Cria um ArrayList para mostrar os nomes das categorias cadastrados no banco de dados
        List<Categoria> mostrarCategorias = categoriaDAO.mostrarCategorias(); 
        //int id = 1;
        
        jComboBoxCategoria.removeAllItems(); //limpa itens anteriores para evitar erros
        
        if(mostrarCategorias.isEmpty()){ //Caso não tenha nenhuma categoria cadastrada vai criar uma categoria informativa
            jComboBoxCategoria.addItem(new Categoria( 0, "Nenhuma categoria cadastrada", "", ""));
            jComboBoxCategoria.setEnabled(false);
        } else{
        for (Categoria categoria : mostrarCategorias) {
            jComboBoxCategoria.addItem(categoria); //Adiciona na ComboBox as categorias já cadastradas
        }
        jComboBoxCategoria.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        JTFUniProduto1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JTFUniProduto2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTFIdProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JBAdicionarProduto = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        JTFValorProduto = new javax.swing.JTextField();
        JTFUniProduto = new javax.swing.JTextField();
        JTFQuantidadeMinimaProduto = new javax.swing.JTextField();
        JTFQuantidadeMaximaProduto = new javax.swing.JTextField();
        JTFQuantidadeProduto = new javax.swing.JTextField();
        JTFNomeProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        JTFUniProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFUniProduto1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tamanho:");

        JTFUniProduto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFUniProduto2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Embalagem:");

        JTFIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFIdProdutoActionPerformed(evt);
            }
        });

        jLabel4.setText("ID:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Novo Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Novo Produto");

        jLabel2.setText("Nome:");

        jLabel5.setText("Valor Unitário:");

        jLabel6.setText("Quantidade máxima em estoque:");

        jLabel7.setText("Unidade:");

        jLabel8.setText("Quantidade em estoque:");

        jLabel9.setText("Quantidade mínima em estoque:");

        JBAdicionarProduto.setText("Adicionar novo produto");
        JBAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarProdutoActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBVoltarMouseClicked(evt);
            }
        });
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JTFValorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFValorProdutoActionPerformed(evt);
            }
        });

        JTFUniProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFUniProdutoActionPerformed(evt);
            }
        });

        JTFQuantidadeMinimaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFQuantidadeMinimaProdutoActionPerformed(evt);
            }
        });

        JTFQuantidadeMaximaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFQuantidadeMaximaProdutoActionPerformed(evt);
            }
        });

        JTFQuantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFQuantidadeProdutoActionPerformed(evt);
            }
        });

        JTFNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeProdutoActionPerformed(evt);
            }
        });

        jLabel11.setText("Categoria:");

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBAdicionarProduto)
                        .addGap(235, 235, 235)
                        .addComponent(JBVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFQuantidadeMaximaProduto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFQuantidadeMinimaProduto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFQuantidadeProduto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFUniProduto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFValorProduto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTFNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207)
                                .addComponent(jLabel1)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JTFValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTFUniProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JTFQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTFQuantidadeMinimaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTFQuantidadeMaximaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBVoltar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBAdicionarProduto)
                        .addGap(15, 15, 15))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_JBVoltarMouseClicked

    private void JTFNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeProdutoActionPerformed

    }//GEN-LAST:event_JTFNomeProdutoActionPerformed

    private void JTFIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFIdProdutoActionPerformed

    }//GEN-LAST:event_JTFIdProdutoActionPerformed

    private void JTFValorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFValorProdutoActionPerformed

    }//GEN-LAST:event_JTFValorProdutoActionPerformed

    private void JTFUniProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFUniProdutoActionPerformed
    }//GEN-LAST:event_JTFUniProdutoActionPerformed

    private void JTFQuantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFQuantidadeProdutoActionPerformed
     }//GEN-LAST:event_JTFQuantidadeProdutoActionPerformed

    private void JTFQuantidadeMinimaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFQuantidadeMinimaProdutoActionPerformed

    }//GEN-LAST:event_JTFQuantidadeMinimaProdutoActionPerformed

    private void JTFQuantidadeMaximaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFQuantidadeMaximaProdutoActionPerformed

    }//GEN-LAST:event_JTFQuantidadeMaximaProdutoActionPerformed

    private void JTFCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCategoriaActionPerformed

    }//GEN-LAST:event_JTFCategoriaActionPerformed

    private void JBAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarProdutoActionPerformed

        try {
            String nomeProduto= "";
            int id = 0;
            double valorUnitario = 0;
            String unidade = "";
            int quantidadeEstoque = 0;
            int quantidadeEstoqueMinima = 0;
            int quantidadeEstoqueMaxima = 0;
            //String nomeCategoria = "";

            //Nome do Produto
            if (this.JTFNomeProduto.getText().length() < 2) {
                throw new Mensagem(" O nome do produto deve conter ao menos 2 caracteres. ");
            } else {
                nomeProduto = this.JTFNomeProduto.getText();
            }

            //Id do Produto
          //  int x = Integer.parseInt(this.JTFIdProduto.getText());
           // if (x <= 0) {
           //     throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
          //  }
          
        //   if (this.JTFIdProduto.getText().length() <= 0) {
        //        throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
        //    } else {
         //       id = Integer.parseInt(this.JTFIdProduto.getText());
         // }

            //Valor do produto
            int x = (int) Double.parseDouble(this.JTFValorProduto.getText());
            if (x <= 0) {
                throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
            }
            if (this.JTFValorProduto.getText().length() <= 0) {
                throw new Mensagem("O valor do produto deve ser número e maior que zero. ");
            } else {
                valorUnitario = Integer.parseInt(this.JTFValorProduto.getText());
            }

            //Unidade de medida do Produto
            if (this.JTFUniProduto.getText().length() < 2) {
                throw new Mensagem("A unidade de medida tem que ser válida e conter ao menos 2 caracteres. ");
            } else {
                unidade = this.JTFUniProduto.getText();
            }

            //Quantidade do produto
            x = Integer.parseInt(this.JTFQuantidadeProduto.getText());
            if (x <= 0) {
                throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
            }
            if (this.JTFQuantidadeProduto.getText().length() <= 0) {
                throw new Mensagem("Insira uma quantidade válida. ");
            } else {
                quantidadeEstoque = Integer.parseInt(this.JTFQuantidadeProduto.getText());
            }

            //Quantidade Mínima do produto
            x = Integer.parseInt(this.JTFQuantidadeMinimaProduto.getText());
            if (x <= 0) {
                throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
            }
            else{
                quantidadeEstoqueMinima = x;
            }
            /*
            if (this.JTFQuantidadeMinimaProduto.getText().length() <= 0) {
                throw new Mensagem("A quantidade mínima do produto deve ser número e maior que zero. ");
            } else {
                int quantidadeMinima = Integer.parseInt(this.JTFQuantidadeMinimaProduto.getText());
            }
*/
            //Quantidade Máxima do produto
            x = Integer.parseInt(this.JTFQuantidadeMaximaProduto.getText());
            if (x <= 0) {
                throw new Mensagem("O Id do produto deve ser número e maior que zero. ");
            }
            else{
                quantidadeEstoqueMaxima = x;
            }
            /*
            if (this.JTFQuantidadeMaximaProduto.getText().length() <= 0) {
                throw new Mensagem("A quantidade máxima do produto deve ser número e maior que zero. ");
            } else {
                int quantidadeMaxima = Integer.parseInt(this.JTFQuantidadeMaximaProduto.getText());
            }
*/
            // limpa campos da interface
            this.JTFNomeProduto.setText("");
           // this.JTFIdProduto.setText("");
            this.JTFValorProduto.setText("");
            this.JTFUniProduto.setText("");
            this.JTFQuantidadeProduto.setText("");
            this.JTFQuantidadeMinimaProduto.setText("");
            this.JTFQuantidadeMaximaProduto.setText("");
           

            
            Categoria categoriaSelecionada = (Categoria) jComboBoxCategoria.getSelectedItem();
            String nomeCategoria = categoriaSelecionada.getNomeCategoria();
            String tamanho = categoriaSelecionada.getTamanho();
            String embalagem = categoriaSelecionada.getEmbalagem();
            
            produtoDAO.cadastrarProduto(nomeProduto, valorUnitario, unidade, quantidadeEstoque,
               quantidadeEstoqueMinima, quantidadeEstoqueMaxima, nomeCategoria, tamanho, embalagem);
            
            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
        } catch (Mensagem e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao converter número: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }


    }//GEN-LAST:event_JBAdicionarProdutoActionPerformed

     private double somaTotalEstoque = 0;

      public void somaTotal() {
      try{
      
      double valorProduto = Double.parseDouble(JTFValorProduto.getText());
      double quantidadeProduto = Double.parseDouble(JTFQuantidadeProduto.getText());
      double valorTotalProduto = valorProduto * quantidadeProduto;
      somaTotalEstoque += valorTotalProduto;
      }
      catch (NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Insira dados válidos.");
      }
      
    }                                                  

      public double getSomaTotalEstoque(){
          return somaTotalEstoque;
      }

    
    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JTFUniProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFUniProduto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFUniProduto1ActionPerformed

    private void JTFUniProduto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFUniProduto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFUniProduto2ActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed

    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     mostrarCategorias();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     mostrarCategorias();
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionarProduto;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFIdProduto;
    private javax.swing.JTextField JTFNomeProduto;
    private javax.swing.JTextField JTFQuantidadeMaximaProduto;
    private javax.swing.JTextField JTFQuantidadeMinimaProduto;
    private javax.swing.JTextField JTFQuantidadeProduto;
    private javax.swing.JTextField JTFUniProduto;
    private javax.swing.JTextField JTFUniProduto1;
    private javax.swing.JTextField JTFUniProduto2;
    private javax.swing.JTextField JTFValorProduto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private static javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
