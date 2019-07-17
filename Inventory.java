/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinventory;

/**
 *
 * @author Student
 */
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Comparator;
public class Inventory {
// Item, Qty
   
    private List<InventoryItem> items;
    private int uhuy;

    public Inventory() {
            this.items = new ArrayList<InventoryItem>();
            
    }

    public List<InventoryItem> getItems() {
       return this.items;
    }
        
        
    public int getItemTotalCount() { 
        this.uhuy = 0;
        for(InventoryItem i: items){
            this.uhuy += i.getQty();
            }
        return this.uhuy;
    }
    
    public boolean inven(Item item){
        for(InventoryItem i: items){
            if(i.getItem().getName().equals(item.getName())){
                return true;
            }
}
        return false;
    }
    
    public int search(Item item){
        for (InventoryItem i: items){
            if(i.getItem().getName().equals(item.getName())){
                return items.indexOf(i);
            }
        }
        return -1;
    }
    // mengembalikan item tertentu, kembalikan -1 jika tidak ditemukan
    public int getItemCount(Item item) { 
        if(inven(item)){
            return items.get(search(item)).getQty();
            
        }
        return -1;
    }
    
    // mengurangi jumlah qty item tertentu, kembalikan jumlah qty yang berhasil diambil
    // jika qty > banyak item di inventory, kembalikan banyak item di inventory
    // jika tidak temukan throw NoSuchElementException
    // jika qty <= 0 throw IllegalArgumentException
    public int takeItem(Item item, int qty) { 
        if(!inven(item)){
            throw new NoSuchElementException();
        }
        if(qty <= 0){
            throw new IllegalArgumentException();
        }
        int mass = getItemCount(item);
        if(qty < mass){
            items.get(search(item)).setQty(mass-qty);
            return qty;
        }
        else if(qty>mass){
            items.get(search(item)).setQty(0);
            return mass;
        }
        return -1;
    }
    // menambahkan item tertentu ke inventory sebanyak inventory
    // jika qty <= 0 throw IllegalArgumentException
    public void putItem(Item item, int qty) { 
        if(qty <= 0) {
            throw new IllegalArgumentException();
        }
        items.add(new InventoryItem(item,qty));
    }
    // kembalikan list items yang diurutkan berdasarkan harga item (descending)
    public List<InventoryItem> getOrderByPrice() { 
        this.items.sort(new Comparator<InventoryItem>(){
            public int compare(InventoryItem Item1, InventoryItem Item2){
                return (int)(Item1.getItem().getPrice()*100 - Item2.getItem().getPrice()*100)*-1;
            }
            });
            return this.items;
    }
    // kembalikan list items yang diurutukan berdasarkan berat item (descending)
    public List<InventoryItem> getOrderByWeight() { 
        this.items.sort(new Comparator<InventoryItem>(){
            public int compare(InventoryItem Item1, InventoryItem Item2){
                return (int)(Item1.getItem().getWeight()*100 - Item2.getItem().getWeight()*100)*-1;
            }
            });
            return this.items;
    }
    // kembalikan list items yang diurutkan berdasarkan qty item (descending)
    public List<InventoryItem> getOrderByQty() {
        this.items.sort(new Comparator<InventoryItem>(){
            public int compare(InventoryItem Item1, InventoryItem Item2){
                return (int)(Item1.getQty() - Item2.getQty())*-1;
            }
            });
            return this.items;
    }    
}
