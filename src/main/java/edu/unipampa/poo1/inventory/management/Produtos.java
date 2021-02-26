package edu.unipampa.poo1.inventory.management;

import java.util.ArrayList;
import java.util.List;

public class Produtos implements IProdutos {
    private List<Produto> estoque = new ArrayList<Produto>();

    public boolean addProduto(Produto p) {
        if (produtoInvalido(p))
            return false;

        estoque.add(p);
        return true;
    }

    public boolean removeProduto(int codigo) {
        var produto = getProduto(codigo);
        if (produto == null) {
            return false;
        }

        estoque.remove(produto);

        return true;
    }

    public Produto getProduto(int codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo)
                return produto;
        }

        return null;
    }

    public boolean updateQuantidade(int codigo, double nova) {
        var produto = getProduto(codigo);
        if (produto == null) {
            return false;
        }

        produto.setQuantidade(nova);

        return true;
    }

    public boolean updatePreco(int codigo, double novo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) {
                produto.setPreco(novo);
                return true;
            }
        }

        return false;
    }

    public boolean addQuantidade(int codigo, double quantidade) {
        var produto = getProduto(codigo);
        if (produto == null) {
            return false;
        }

        produto.setQuantidade(produto.getQuantidade() + quantidade);

        return true;
    }

    public boolean subQuantidade(int codigo, double quantidade) {
        var produto = getProduto(codigo);
        if (produto == null || (produto.getQuantidade() - quantidade) < 0) {
            return false;
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);

        return true;
    }

    private boolean produtoInvalido(Produto p) {
        boolean invalido = false;

        for (Produto produto : estoque) {
            invalido = produto.getNome().equalsIgnoreCase(p.getNome());
            if (invalido) {
                break;
            }
        }

        return invalido;
    }
}
