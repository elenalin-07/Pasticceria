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
    protected ArrayList<Materiale> materiali = new ArrayList<>();
    protected int qualita;
    
    public void aggiungiMateriale(Materiale m){
        materiali.add(m);
        qualita += m.getQualita();
    }
    
    public Dessert getDessert(){
        return this;
    }
}
