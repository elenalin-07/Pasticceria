/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

/**
 *
 * @author zxt02
 */
public class Pasticcere {
    private int livello = 1, puntiEsperienza = 0, maxPunti, costo;
    private String nome;
    
    public Pasticcere(String n){
        this.nome = n;
        costo = 100;
    }
    
    public void aumentaQualita(Dessert d){
        switch(nome){
            case "Luca":
                int q = livello * 15;
                d.aumentaQualita(q);
                break;
            case "Mellisa":
                d.aumentaPrezzo();
                break;
            case "Paolo":
                d.dimnuireCosto();
                break;
        }   
        int q = livello * 8;
        d.aumentaQualita(q);
    }
    
    public void aumentaEsperienza(){
        puntiEsperienza += 100;
        checkPunti();
    }
    
    public void aumentaLevel(){
        if(livello < 5){
        livello++;
        costo = livello * 100;
        }
    }
    
    public void checkPunti(){
        maxPunti = livello * 500;
        if(puntiEsperienza >= maxPunti){
            puntiEsperienza -= maxPunti;
            aumentaLevel();
        }
    }
    
    public int getCosto(){
        return costo;
    }
    
}
