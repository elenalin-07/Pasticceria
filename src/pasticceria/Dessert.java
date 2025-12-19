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
    protected int qualita, costoProduzione, prezzo, quantita, numIngredient;
    protected boolean stato, fallito;
    
    public Dessert(){
        ingredienti = new ArrayList<>();
        stato = false;
        fallito = false;
        quantita = 20;
        numIngredient = 0;
        costoProduzione = 0;
        prezzo = 0;
    }
    
    public abstract String setImage();
    
    public void aumentaPrezzo(){
        prezzo += prezzo * 10/100;
    }
    
    public void dimnuireCosto(){
        costoProduzione -= costoProduzione * 20/100;
    }
    
    public void addIngrediente(Ingrediente i, int n){
        int posizione;
        numIngredient++;
        if(numIngredient <= 3){
            ingredienti.add(i);
            qualita += i.getQualita();
        }
        else{
            posizione = numIngredient - (n+3);
            qualita -= ingredienti.get(posizione).getQualita();
            ingredienti.remove(posizione);
            ingredienti.add(i);
            qualita += i.getQualita();
        }
        if(numIngredient >= 6) numIngredient = 3;
    }
    
    public int calcolaCosto(){
        for(Ingrediente i : ingredienti){
            costoProduzione += i.getCosto();
        }
        return costoProduzione;
    }
    
    public void diminuiQuantita(int n){
        quantita -= n;
    }
    
    public int vendita(int richiesta){
        if(richiesta <= quantita){
            quantita -= richiesta;
            return richiesta;
        } else {
            int venduti = quantita;
            quantita = 0;
            return venduti;
        }
    }

    
    public void setQualita(){
        qualita = 100;
    }
    
    public void aumentaQualita(int q){
        qualita += q;
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
        if(!fallito) prezzo = costoProduzione + costoProduzione * 10 / 100;
        else prezzo = 0;
        return prezzo;
    }
    
    public int getCostoProduzione(){
        return costoProduzione;
    }
    
    public int getQuantita(){
        return quantita;
    }
}
