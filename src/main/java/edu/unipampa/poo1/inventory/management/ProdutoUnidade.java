package edu.unipampa.poo1.inventory.management;

public class ProdutoUnidade extends Produto {
    private int _quantidade;

    public ProdutoUnidade(String nome, String descricao, double preco, double quantidade) {
        super(nome, descricao, preco);

        _quantidade = (int) quantidade;
    }

    @Override
    public double getQuantidade() {
        return _quantidade;
    }

    @Override
    public void setQuantidade(double quantidade) {
        _quantidade = (int) quantidade;
    }
}
