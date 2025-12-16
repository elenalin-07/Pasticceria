/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

import java.util.ArrayList;

/**
 *
 * @author zxt02
 */
public class Stand {
    ArrayList<Dessert> desserts;
    
    public Stand(){
        desserts = new ArrayList<>();
    }
    
    public void aagiungiDessert(Dessert d){
        if(!desserts.contains(d)) desserts.add(d);
    }
    
    public void removeDessert(Dessert d){
        if(desserts.contains(d)) desserts.remove(d);
    }
    
    public ArrayList<Dessert> getDesserts(){
        return desserts;
    }
}
