/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Client c;
    Random r = new Random();
    
    public Negozio(){
        desserts = new ArrayList<>();
        pasticceri = new ArrayList<>();
        soldi = 1000;
        vendite = new ArrayList<>();
    }
    
    public void addDessert(Dessert d){
        soldi -= 80;
        desserts.add(d);
    }
    
    public void removeDessert(Dessert d){
        desserts.remove(d);
    }
    
    public void incendio(){
        desserts.clear();
    }
    
    public boolean checkSoldi(){
        if(soldi < 0) return false;
        return true;
    }
    
    public int vende(int q, Dessert d){
        int p = d.getPrezzo();
        int ptot = p * q;
        soldi += ptot; 
        return ptot;
    }

    public void addVendita(Dessert d){
        vendite.add(d);
        soldi -= d.getCostoProduzione();
    }
    
    public HashMap<String, Object> compra(){
        int maxQualita = 0, pos = 0, qualita, soldi, prezzo, quantita;
        Dessert dessertSelezionato;
        for(int i = 0; i < vendite.size(); i++){
            qualita = vendite.get(i).getQualita();
            if(qualita > maxQualita){
                maxQualita = qualita;
                pos = i;
            }
        }
        c = new Client();
        soldi = c.getSoldi();
        
        dessertSelezionato = random(pos);
        
        HashMap<String, Object> m = new HashMap<>();
        
        if(dessertSelezionato != null){
            prezzo = dessertSelezionato.getPrezzo();
            quantita = soldi / prezzo;
            m.put("dessert", dessertSelezionato);
            m.put("quantita", quantita);
        }
        else{
            m.put("dessert", null);
            m.put("quantita", 0);
        }
        return m;
    }
    
    public Dessert random(int pos){
        int p, i = 0;
        Dessert[] d = new Dessert[10];
        
        while(i < 5){
           p = r.nextInt(d.length);
           d[p] = vendite.get(pos);
           i++;
        }
        
        i = 0;
        
        if(vendite.size() != 1){
            if(vendite.size() >= 2){
                while(i < 2){
                    for(int x = 0; x < d.length; x++){
                        if(d[x] == null){
                            if(pos - 1 < 0) d[x] = vendite.get(vendite.size() - 1);
                            else d[x] = vendite.get(pos - 1);
                            i++;
                        }
                    }
                }
                if(vendite.size() == 3){
                    while(i < 2){
                        for(int x = 0; x < d.length; x++){
                            if(d[x] == null){
                                if(pos + 1 < 0) d[x] = vendite.get(vendite.size() - 1);
                                else d[x] = vendite.get(pos + 1);
                                i++;
                            }
                        }
                    }
                }
            }
        }
        
        int dessert = r.nextInt(d.length);
        return d[dessert];
    }
    
    public void removeVendita(Dessert d){
        vendite.remove(d);
    }
    
    public void rimborso(int n, Dessert d){
        int prezzo = d.getPrezzo();
        int s = prezzo * n * -1;
        soldi += s;
    }
    
    public int getSoldi(){
        return soldi;
    }
    
    public void diminuiSoldi(int c){
        soldi -= c;
    }
}
