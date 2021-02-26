package edu.unipampa.poo1.inventory.management;

public class ProdutoQuilo extends Produto {
    private double _quantidade;

    public ProdutoQuilo(String nome, String descricao, double preco, double quantidade) {
        super(nome, descricao, preco, TipoQuantidade.KILO);

        _quantidade = quantidade;
    }

    public double getQuantidade() {
        return _quantidade;
    }

    public void setQuantidade(double quantidade) {
        _quantidade = quantidade;
    }
}
