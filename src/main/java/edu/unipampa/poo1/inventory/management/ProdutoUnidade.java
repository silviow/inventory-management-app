package edu.unipampa.poo1.inventory.management;

public class ProdutoUnidade extends Produto {
    private int _quantidade;

    public ProdutoUnidade(String nome, String descricao, double preco, int quantidade) {
        super(nome, descricao, preco, TipoQuantidade.UNIDADE);

        _quantidade = quantidade;
    }

    public int getQuantidade() {
        return _quantidade;
    }

    public void setQuantidade(int quantidade) {
        _quantidade = quantidade;
    }
}
