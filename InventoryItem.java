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
public class InventoryItem {
    private Item item;
    private int qty;

    // default qty = 0
    public InventoryItem(Item item) {
        this.item = null;
    }

    // default qty = qty
    public InventoryItem(Item item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    // kembalikan item
    public Item getItem() { 
        return this.item;
    }
    // kembalikan jumlah qty
    public int getQty() { 
        return this.qty;
    }

    // ubah qty menjadi sebanyak qty
    // jika qty < 0 throw IllegalArgumentException
    public int setQty(int qty) { 
        if (qty < 0){
            throw new IllegalArgumentException("Error");
        }
        else{
            return this.qty = qty;
        }
    }

    public String toString() {
            return String.format("<InventoryItem:%s:%d>", item.toString(), qty);
    }
}
