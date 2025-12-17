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
public abstract class Dessert {
    protected ArrayList<Ingrediente> ingredienti;
    protected int qualita, costoProduzione, prezzo, popolarita, quantita, numIngredient;
    private boolean stato;
    
    public Dessert(){
        ingredienti = new ArrayList<>();
        stato = false;
        quantita = 20;
        numIngredient = 0;
    }
    
    public abstract String setImage();
    
    public void addIngrediente(Ingrediente i, int n){
        int posizione;
        numIngredient++;
        if(numIngredient <= 3){
            ingredienti.add(i);
        }
        else{
            System.out.println(numIngredient + "+" + n);
            posizione = numIngredient - (n+3);
            ingredienti.remove(posizione);
            ingredienti.add(i);
        }
        if(numIngredient >= 6) numIngredient = 3;
    }
    
    public void vendita(){
        quantita--;
    }
    
    public ArrayList<Ingrediente> getIngredienti(){
        return ingredienti;
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
