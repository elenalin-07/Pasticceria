/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

/**
 *
 * @author zxt02
 */
public class Materiale {
    private String nome;
    private int costo, qualita;
    
    public Materiale(String n, int c,int q){
        this.nome = n;
        this.costo = c;
        this.qualita = q;
    }
    
    public int getCosto(){
        return costo;
    }
    
    public int getQualita(){
        return qualita;
    }
}
