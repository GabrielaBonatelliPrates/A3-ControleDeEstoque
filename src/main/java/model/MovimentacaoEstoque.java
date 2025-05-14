package model;

public class MovimentacaoEstoque {

    private int data; //se possivel implementar a data
    private String tipoMovimentacao;
    private int quantidadeMovimentada;
    private String nomeProduto;

    public MovimentacaoEstoque(int quantidadeMovimentada, String nomeProduto) {
        this.quantidadeMovimentada = quantidadeMovimentada;
        this.nomeProduto = nomeProduto;
    }

    public MovimentacaoEstoque() {
    }

    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

        public
    void atualizaEstoque () {
        int posicao = super.consultaProduto ();
        if (!produtos.isEmpty () && posicao != -1) { //se a lista nao estiver vazia e o produto tiver sido encontrado
            Produto produtoPesquisado = produtos.get (posicao); //transforma o produto pesquisado no produto que ta naquela posicao
            setNomeProduto ( produtoPesquisado.getNomeProduto ());
            int estoqueInicial = produtoPesquisado.getQuantidadeEstoque ();

            System.out.println ("\nO estoque do produto teve:");
            System.out.println ("1. Entrada");
            System.out.println ("2. Saída");
            System.out.println ("3. Voltar");
            System.out.print ("Escolha uma opção: ");


            int escolha = input.nextInt ();
            input.nextLine (); //limpar quebra de linha

            switch (escolha) {
                case 1: //se o usuario escolher entrada, o tipo de movimento vira entrada, e o estoque inicial é somado à entrada
                    setTipoMovimentacao ("entrada");
                    System.out.print ("Digite a quantidade de entrada: ");
                    int entrada = input.nextInt ();
                    setQuantidadeMovimentada (entrada);
                    input.nextLine ();

                    int estoqueAtualEntrada = estoqueInicial + entrada;

                    //verifica a nova condição do estaque aos estoques maximos e minimos
                    if (estoqueAtualEntrada > produtoPesquisado.getEstoqueMaximo ()) {
                        System.out.println ("Estoque excede o limite máximo permitido.");
                    } else if (estoqueAtualEntrada < produtoPesquisado.getEstoqueMinimo ()) {
                        System.out.println ("Estoque abaixo do mínimo permitido.");
                    } else {
                        produtoPesquisado.setQuantidadeEstoque (estoqueAtualEntrada);
                        System.out.println ("Entrada registrada com sucesso.");
                    }
                    break;

                case 2:  //se o usuario escolher saida, o tipo de movimento vira saida, e o estoque inicial é subtraido à saida
                    setTipoMovimentacao ("saída");
                    System.out.print ("Digite a quantidade de saída: ");
                    int saida = input.nextInt ();
                    setQuantidadeMovimentada (saida);
                    input.nextLine ();

                    int estoqueAtualSaida = estoqueInicial - saida;

                    //verifica a nova condição do estaque aos estoques maximos e minimos
                    if (estoqueAtualSaida > produtoPesquisado.getEstoqueMaximo ()) {
                        System.out.println ("Estoque excede o limite máximo permitido.");
                    } else if (estoqueAtualSaida < produtoPesquisado.getEstoqueMinimo ()) {
                        System.out.println ("Estoque abaixo do mínimo permitido.");
                    } else {
                        produtoPesquisado.setQuantidadeEstoque (estoqueAtualSaida);
                        System.out.println ("Saída registrada com sucesso.");
                    }
                    break;

                case 3:
                    System.out.println ("Voltando...");
                    break;

                default:
                    System.out.println ("Opção inválida.");
            }

            //exibe as infos atualizadas do produto
            System.out.println ("\nInformações do Produto Atualizado:");
            System.out.println ("Nome: " + produtoPesquisado.getNomeProduto ());
            System.out.println ("Quantidade Atual: " + produtoPesquisado.getQuantidadeEstoque ());
            System.out.println ("Quantidade Mínima: " + produtoPesquisado.getEstoqueMinimo ());
            System.out.println ("Quantidade Máxima: " + produtoPesquisado.getEstoqueMaximo ());

        }
    }
}


