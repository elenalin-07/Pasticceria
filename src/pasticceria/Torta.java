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
    private ArrayList<Ingrediente> cannella;
    private ArrayList<Ingrediente> tiramisu;
    
    private ArrayList<ArrayList<Ingrediente>> ricetteTorta;
    
    private int numRicetta;
    
    public Torta(){
        costoProduzione += 50;
        
        fragola = new ArrayList<>();
        cioccolato = new ArrayList<>();
        latte = new ArrayList<>();
        cannella = new ArrayList<>();
        tiramisu = new ArrayList<>();
        ricetteTorta = new ArrayList<>();
        
        fragola.add(new Ingrediente("fragola", 0, ""));
        fragola.add(new Ingrediente("farina", 0, ""));
        fragola.add(new Ingrediente("uova", 0, ""));
        
        cioccolato.add(new Ingrediente("cioccolato", 0, ""));
        cioccolato.add(new Ingrediente("farina", 0, ""));
        cioccolato.add(new Ingrediente("uova", 0, ""));
        
        latte.add(new Ingrediente("latte", 0, ""));
        latte.add(new Ingrediente("farina", 0, ""));
        latte.add(new Ingrediente("uova", 0, ""));
        
        cannella.add(new Ingrediente("cannella", 0, ""));
        cannella.add(new Ingrediente("farina", 0, ""));
        cannella.add(new Ingrediente("uova", 0, ""));
        
        tiramisu.add(new Ingrediente("formaggio cremoso", 0, ""));
        tiramisu.add(new Ingrediente("cacao", 0, ""));
        tiramisu.add(new Ingrediente("liquore", 0, ""));
        
        ricetteTorta.add(fragola);
        ricetteTorta.add(cioccolato);
        ricetteTorta.add(latte);
        ricetteTorta.add(cannella);
        ricetteTorta.add(tiramisu);
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
        for (int i = 0; i < ricetteTorta.size(); i++) {
            ArrayList<Ingrediente> ricetta = ricetteTorta.get(i);
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
                    return "torta fragola";
                case 1:
                    return "torta cioccolato"; 
                case 2:
                    return "torta latte";
                case 3:
                    return "girella"; 
                case 4:
                    return "tiramisu";              }
        }
        fallito = true;
        qualita = 0;
        return "fallimento";
    }
}
