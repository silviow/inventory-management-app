package edu.unipampa.poo1.inventory.management;

public interface IProdutos {
    public abstract boolean addProduto(Produto p);

    public abstract boolean removeProduto(int codigo);

    public abstract Produto getProduto(int codigo);

    public abstract boolean updateQuantidade(int codigo, double nova);

    public abstract boolean updatePreco(int codigo, double novo);

    public abstract boolean addQuantidade(int codigo, double quantidade);

    public abstract boolean subQuantidade(int codigo, double quantidade);
}
