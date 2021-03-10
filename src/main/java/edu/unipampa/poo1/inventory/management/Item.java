package edu.unipampa.poo1.inventory.management;

public class Item {
    private Produto _produto;
    private int _quantidade;

    public Item(Produto produto, int quantidade) {
        _produto = produto;
        _quantidade = quantidade;
    }

    public Produto getProduto() {
        return _produto;
    }

    public void setProduto(Produto produto) {
        _produto = produto;
    }

    public int getQuantidade() {
        return _quantidade;
    }

    public void setQuantidade(int quantidade) {
        _quantidade = quantidade;
    }
}
