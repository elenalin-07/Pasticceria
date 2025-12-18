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
public class Gelato extends Dessert{
    private ArrayList<Ingrediente> fragola;
    private ArrayList<Ingrediente> cioccolato;
    private ArrayList<Ingrediente> caffe;
    private ArrayList<Ingrediente> vaniglia;
    
    private ArrayList<ArrayList<Ingrediente>> ricetteGelato;
    
    private int numRicetta;
    
    public Gelato(){
        costoProduzione += 15;
        
        fragola = new ArrayList<>();
        cioccolato = new ArrayList<>();
        caffe = new ArrayList<>();
        vaniglia = new ArrayList<>();
        ricetteGelato = new ArrayList<>();
        
        fragola.add(new Ingrediente("panna", 0, ""));
        fragola.add(new Ingrediente("latte condensato", 0, ""));
        fragola.add(new Ingrediente("fragola", 0, ""));
        
        cioccolato.add(new Ingrediente("panna", 0, ""));
        cioccolato.add(new Ingrediente("latte condensato", 0, ""));
        cioccolato.add(new Ingrediente("cioccolato", 0, ""));
        
        caffe.add(new Ingrediente("panna", 0, ""));
        caffe.add(new Ingrediente("latte condensato", 0, ""));
        caffe.add(new Ingrediente("caffe", 0, ""));
        
        vaniglia.add(new Ingrediente("panna", 0, ""));
        vaniglia.add(new Ingrediente("latte condensato", 0, ""));
        vaniglia.add(new Ingrediente("vaniglia", 0, ""));
        
        ricetteGelato.add(fragola);
        ricetteGelato.add(cioccolato);
        ricetteGelato.add(caffe);
        ricetteGelato.add(vaniglia);
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
        for (int i = 0; i < ricetteGelato.size(); i++) {
            ArrayList<Ingrediente> ricetta = ricetteGelato.get(i);
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
                    return "gelato fragola";
                case 1:
                    return "gelato cioccolato"; 
                case 2:
                    return "gelato caffe";
                case 3:
                    return "gelato vaniglia";             }
        }
        return "fallimento";
    }
}
