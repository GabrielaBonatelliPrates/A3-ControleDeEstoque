# Sistema de Controle de Estoque

Este projeto foi desenvolvido como parte da disciplina de **Programação de Soluções Computacionais** na UNISUL. O sistema realiza o controle de estoque utilizando Java e MySQL.

---

## 👥 Integrantes do Grupo

| Nome Completo                        | RA           | Usuário GitHub                   |
|--------------------------------------|--------------|----------------------------------|
| Davi Wolff de Abreu                  | 10725112049  | Davi-Wolff                       |
| Ester da Rosa Mariani                | 10725115450  | Estermrn                         |
| Gabriela Bonatelli Prates            | 10725112623  | GabrielaBonatelliPrates          |
| Laís Paiva Portela                   | 1072517961   | laispaivaportela                 |
| Mateo Alessandro Padilla Chalela     | 1072519604   | Mateo-Padilla                    |

---

## 🗃️ Banco de Dados

O arquivo "[bancoDeDados.sql](./bancoDeDados.sql)"
 foi criado para gerar o banco de dados e suas respectivas tabelas.

**Credenciais de acesso ao banco de dados:**

- **Usuário:** "root" 
- **Senha:** "senha"

---

## 🛠️ Tecnologias Utilizadas

- **Java Development Kit (JDK)**: 23.0.2  
- **MySQL Server**: 9.3  
- **SQL Workbench**: 8.0  
- **IDE**: Apache NetBeans 25

---

## ✅ Requisitos Funcionais

- **RF01: Cadastrar Produto**  
  Permite que o usuário crie e armazene um novo produto no estoque, informando:
  - Nome
  - Preço unitário
  - Unidade
  - Quantidade em estoque
  - Estoque mínimo e máximo
  - Categoria do produto

- **RF02: Atualizar Produto**  
  Permite que o usuário altere os dados anteriormente cadastrados de um produto.

- **RF03: Excluir Produto**  
  Permite que o usuário exclua um produto cadastrado no sistema.

- **RF04: Cadastrar Categoria**  
  Permite que o usuário crie uma nova categoria, informando:
  - Nome
  - Tamanho
  - Tipo de embalagem

- **RF05: Atualizar Categoria**  
  Permite atualizar os dados de uma categoria existente.

- **RF06: Excluir Categoria**  
  Permite excluir uma categoria cadastrada.

- **RF07: Movimentar Estoque**  
  Permite realizar acréscimos ou reduções na quantidade de produtos, de acordo com a entrada ou saída de estoque.

- **RF08: Listar Produtos**  
  Exibe uma lista com todos os produtos cadastrados. Também permite pesquisa e visualização dos dados e status de cada produto.

- **RF09: Listar Categorias**  
  Exibe uma lista com todas as categorias cadastradas, com opção de busca e visualização de dados.

- **RF10: Gerar Relatório de Lista de Preços**

Esta função permite que o usuário visualize o relatório de preços dos produtos.  

É gerada uma tabela contendo:

- Nome do produto  
- Preço unitário  
- Unidade de medida  
- Categoria do produto  

---

- **RF11: Gerar Relatório de Balanço Financeiro**

Esta função permite que o usuário visualize o relatório físico/financeiro do estoque.  

É gerada uma tabela contendo:

- Nome do produto  
- Preço unitário  
- Quantidade em estoque  
- Valor total do produto em estoque (preço unitário × quantidade)

Além disso, o relatório exibe o valor total do estoque geral, proporcionando uma visão consolidada do estoque.

---

- **RF12: Gerar Relatório de Quantidade de Produtos por Categoria**

Esta função permite que o usuário visualize quantos produtos existem em cada categoria.  

É gerada uma tabela contendo:

- Categoria do produto  
- Quantidade de produtos por categoria

---

- **RF13: Gerar Relatório de Produtos Abaixo da Quantidade Mínima**

Esta função permite que o usuário visualize os produtos com estoque abaixo do mínimo cadastrado.  

É gerada uma tabela contendo:

- ID do produto  
- Nome do produto  
- Quantidade atual em estoque  
- Quantidade mínima cadastrada  

---

- **RF14: Gerar Relatório de Produtos Acima da Quantidade Máxima**

Esta função permite que o usuário visualize os produtos com estoque acima do máximo cadastrado.  

É gerada uma tabela contendo:

- ID do produto  
- Nome do produto  
- Quantidade atual em estoque  
- Quantidade máxima cadastrada  

---
