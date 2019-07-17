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
public class Item {
    private String name;
    private double weight;
    private double price;
    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public double getWeight(){
        return this.weight;
    }

    // implementasi getter untuk name, weight, price
    public String toString() {
            return String.format("Item<%s:%.2f:%.2f>", name, weight, price);
    }
}
