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
public class Dessert {
    protected ArrayList<Ingredienti> ingredienti = new ArrayList<>();
    protected int qualita, costoProduzione, prezzo, popolarita, quantita;
    private boolean stato;
    
    public Dessert(){
        stato = false;
        quantita = 20;
    }
    
    public void aggiungiMateriale(Ingredienti i){
        ingredienti.add(i);
        qualita += i.getQualita();
    }
    
    public void vendita(){
        quantita--;
    }
    
    public Dessert getDessert(){
        return this;
    }
    
    public int getQualita(){
        return qualita;
    }
    
    public int getPrezzo(){
        return prezzo;
    }
    
    public int getPopolarita(){
        return popolarita;
    }
    
    public int getQuantita(){
        return quantita;
    }
}
