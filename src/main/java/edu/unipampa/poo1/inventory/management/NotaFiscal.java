package edu.unipampa.poo1.inventory.management;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    
    public static int quantidade;
    private int codigo;
    private Calendar data;
    private List<Item> arrayItems = new ArrayList<>();

    public NotaFiscal(){
        quantidade++;
        codigo = quantidade;
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
        int i = temEsseItem(item);
        if (i != -1 && item.getQuantidade() <= item.getProduto().getQuantidade()){
            arrayItems.get(i).setQuantidade(arrayItems.get(i).getQuantidade() + item.getQuantidade());
            return true;
        }else if (i != -1){
            arrayItems.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item){
        int i = temEsseItem(item);
        if (i != -1){
            arrayItems.remove(arrayItems.get(i));
            return true;
        }
        return false;
    }

    private int temEsseItem(Item item){
        for (Item i : arrayItems){
            if (i.getProduto().getCodigo() == item.getProduto().getCodigo()){
                return arrayItems.indexOf(i);
            }
        }
        return -1;
    }
}
