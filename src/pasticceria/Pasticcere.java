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
    private int livello = 0, puntiEsperienza = 0, maxPunti;
    private String nome;
    private Dessert dessert;
    
    public Pasticcere(String n, Dessert dessert){
        this.nome = n;
    }
    
    public void aumentaEsperienza(){
        puntiEsperienza += 100;
        checkPunti();
    }
    
    public void aumentaLevel(){
        livello++;
    }
    
    public void checkPunti(){
        maxPunti = livello * 500;
        if(puntiEsperienza >= maxPunti){
            puntiEsperienza -= maxPunti;
            aumentaLevel();
        }
    }
    
    public void setDessrt(){
        
    }
}
