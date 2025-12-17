/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lin.elena
 */
public class Negozio {
    ArrayList<Dessert> desserts;
    ArrayList<Dessert> vendite;
    ArrayList<Pasticcere> pasticceri;
    private int soldi, mese;
    Random r = new Random();
    
    public Negozio(){
        desserts = new ArrayList<>();
        pasticceri = new ArrayList<>();
    }
    
    public void addDessert(Dessert d){
        desserts.add(d);
    }
    
    public void removeDessert(Dessert d){
        desserts.remove(d);
    }
    public void incendio(){
        int n = r.nextInt(1,6);
        for(int i = 0; i < n; i++){
            desserts.remove(i);
        }
    }
    
    public void festa(){
        
    }
    
    public void incremento(){
        
    }
    
    public int eventiCasuali(){
        int num = r.nextInt(1,10);
        switch(num){
            case 2:
                incendio();
                break;
            case 3:
                festa();
                break;
            case 5:
                incremento();
                break;
            case 7:
                // sciopero
                return 7;
        }
        return 0;
    }
    
    public void compra(){
        int max = 0, i = 0;
        for(Dessert dessert : vendite){
            if(dessert.getPopolarita() > max){
                max = dessert.getPopolarita();
                i++;
            }
        }
        int quantita = r.nextInt(1,4);
        int prezzo = vendite.get(i).getPopolarita();
        int spessa = quantita * prezzo;
        if(spessa > soldi){
            while(spessa > soldi && quantita >= 0){
                quantita--;
                spessa = quantita * prezzo;
            }
            /*if(spessa > soldi){
                int max2 = 0;
                for(Dessert dessert : vendite){
                    if(dessert.getPopolarita() > max2 && dessert.getPopolarita() < max 1;){
                        max = dessert.getPopolarita();
                        i++;
                    }
                }
            }*/
        }
    }
}
