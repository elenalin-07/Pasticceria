/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

/**
 *
 * @author zxt02
 */
public class Ingredienti {
    private String nome;
    private int costo, qualita;
    
    public Ingredienti(String n, int c,int q){
        this.nome = n;
        this.costo = c;
        this.qualita = q;
    }
    
    public void incremento(){
        costo += costo * 20/100;
    }
        
    public int getCosto(){
        return costo;
    }
    
    public int getQualita(){
        return qualita;
    }
}
