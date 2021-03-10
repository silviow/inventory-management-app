package edu.unipampa.poo1.inventory.management;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    
    public static int numero;
    private int codigo;
    private Calendar data;
    private List<Item> arrayItems = new ArrayList<>();

    public NotaFiscal(){
        numero++;
        codigo = numero;
        data = Calendar.getInstance();
    }

    public int getCodigo(){
        return codigo;
    }

    public Calendar getCalendar(){
        return data;
    }

    public List<Item> getItems(){
        return arrayItems;
    }

    public boolean addItem(Item item){
        int codigo = item.getProduto().getCodigo();
        boolean tem = temEsseItem(codigo);
        if (tem && item.getQuantidade() <= item.getProduto().getQuantidade()){
            int n = findItem(codigo);
            arrayItems.get(n).setQuantidade(arrayItems.get(n).getQuantidade() + item.getQuantidade());
            return true;
        }else if (item.getQuantidade() <= item.getProduto().getQuantidade()){
            arrayItems.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(int codigo){

        boolean tem = temEsseItem(codigo);
        if (tem){
            int n = findItem(codigo);
            arrayItems.remove(arrayItems.get(n));
            return true;
        }
        return false;
    }

    private boolean temEsseItem(int codigo){
        for (Item i : arrayItems){
            if (i.getProduto().getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }
    private int findItem(int codigo){
        for (Item i : arrayItems){
            if (i.getProduto().getCodigo() == codigo){
                return arrayItems.indexOf(i);
            }
        }
        return 0;
    }
}
