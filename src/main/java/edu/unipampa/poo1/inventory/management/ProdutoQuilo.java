package edu.unipampa.poo1.inventory.management;

public class ProdutoQuilo extends Produto {
    private double _quantidade;

    public ProdutoQuilo(String nome, String descricao, double preco, double quantidade) {
        super(nome, descricao, preco);

        _quantidade = quantidade;
    }

    @Override
    public double getQuantidade() {
        return _quantidade;
    }

    @Override
    public void setQuantidade(double quantidade) {
        _quantidade = quantidade;
    }
}
