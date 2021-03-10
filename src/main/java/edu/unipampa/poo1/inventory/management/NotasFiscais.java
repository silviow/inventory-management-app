package edu.unipampa.poo1.inventory.management;

import java.util.List;
import java.util.ArrayList;

public class NotasFiscais implements INotasFiscais{
    
    private List<NotaFiscal> arrayNotasFiscais = new ArrayList<>();

    public boolean addNotaFiscal(NotaFiscal nf){
        arrayNotasFiscais.add(nf);
        return true;
    }

    public boolean removeNotaFiscal(int codigo){
        NotaFiscal nf = findNotaFiscal(codigo);
        if (nf != null){
            arrayNotasFiscais.remove(nf);
            return true;
        }
        return false;
    }

    public NotaFiscal getNotaFiscal(int codigo){
        NotaFiscal nf = findNotaFiscal(codigo);
        return nf;
    }

    public List<NotaFiscal> getNotasFiscais() {
        return arrayNotasFiscais;
    }

    public double getTotal(int codigo){
        double total = 0f;
        NotaFiscal nf = findNotaFiscal(codigo);
        if (nf != null){
            total = getSoma(nf.getItems());
        }
        return total;
    }

    public boolean addItem(int codigo, Item item){
        return arrayNotasFiscais.get(codigo).addItem(item);
    }

    public boolean removeItem(int codigo, Item item){
        return arrayNotasFiscais.get(codigo).removeItem(item);
    }

    private double getSoma(List<Item> arrayItem){
        double soma = 0f;
        for (Item i : arrayItem){
            soma += (i.getProduto().getPreco()) * i.getQuantidade();
        }
        return soma;
    }

    private NotaFiscal findNotaFiscal(int codigo){
        for (NotaFiscal nf : arrayNotasFiscais){
            if (nf.getCodigo() == codigo){
                return nf;
            }
        }
        return null;
    }
}
