/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author zxt02
 */
public class Client {
    private int quantita, soldi;
    Random r = new Random();
    
    public Client(){
        soldi = r.nextInt(200, 3001);
    }
    
    public void compra(ArrayList<Dessert> d){
        int max = 0, i = 0;
        for(Dessert dessert : d){
            if(dessert.getPopolarita() > max){
                max = dessert.getQualita();
                i++;
            }
        }
        quantita = r.nextInt(1,4);
        int prezzo = d.get(i).getPopolarita();
        int spessa = quantita * prezzo;
        if(d.get(i).getQuantita() - quantita <= 0){
        }
        else if(spessa > soldi){
            while(spessa > soldi){
                quantita--;
                spessa = quantita * prezzo;
            }
        }
    }
}
