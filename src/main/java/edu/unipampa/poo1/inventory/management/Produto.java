package edu.unipampa.poo1.inventory.management;

public abstract class Produto {
    public static int qtdProdutos;
    private int _codigo;
    private String _nome;
    private String _descricao;
    private double _preco;

    protected Produto(String nome, String descricao, double preco) {
        qtdProdutos++;
        _codigo = qtdProdutos;
        _nome = nome;
        _descricao = descricao;
        _preco = preco;
    }

    protected int getCodigo() {
        return _codigo;
    }

    protected String getNome() {
        return _nome;
    }

    protected void setNome(String nome) {
        _nome = nome;
    }

    protected String getDescricao() {
        return _descricao;
    }

    protected void setDescricao(String descricao) {
        _descricao = descricao;
    }

    protected double getPreco() {
        return _preco;
    }

    protected void setPreco(double preco) {
        _preco = preco;
    }

    public abstract void setQuantidade(double quantidade);

    public abstract double getQuantidade();
}
