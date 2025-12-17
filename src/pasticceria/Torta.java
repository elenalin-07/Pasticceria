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
public class Torta extends Dessert{
    private ArrayList<Ingrediente> fragola;
    private ArrayList<Ingrediente> cioccolato;
    private ArrayList<Ingrediente> latte;
    private ArrayList<Ingrediente> crema;
    
    private ArrayList<ArrayList<Ingrediente>> ricetteDonut;
    
    private int numRicetta;
    
    public Torta(){
        costoProduzione += 50;
    }
    
    public boolean ingredientiSufficienti(ArrayList<Ingrediente> ingredienti, ArrayList<Ingrediente> ricetta) {
        for (Ingrediente ingRicetta : ricetta) {
            boolean trovato = false;
            for (Ingrediente ing: ingredienti) {
                if (ingRicetta.getNome().equalsIgnoreCase(ing.getNome())) {
                    trovato = true;
                    break;
                }
            }
            if (!trovato) return false; 
        }
        return true;
    }
    
    public boolean checkRicetta() {
        for (int i = 0; i < ricetteDonut.size(); i++) {
            ArrayList<Ingrediente> ricetta = ricetteDonut.get(i);
            if (ingredientiSufficienti(ingredienti, ricetta)) {
                numRicetta = i;
                return true; 
            }
        }
        return false; 
    }

    @Override
    public String setImage(){
        if(checkRicetta()){
            switch(numRicetta){
                case 0:
                    return "donut fragola";
                case 1:
                    return "donut cioccolato"; 
                case 2:
                    return "donut latte";
                case 3:
                    return "donut crema";             }
        }
        return "fallimento";
    }
}
