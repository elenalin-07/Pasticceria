/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasticceria;

/**
 *
 * @author zxt02
 */
public class Ingrediente {
    private String nome, qualita;
    private int costo;
    
    public Ingrediente(String n, int c, String q){
        this.nome = n;
        this.costo = c;
        this.qualita = q;
    }
    
    public String getNome(){
        return nome;
    }
    public void incremento(){
        costo += costo * 20/100;
    }
        
    public int getCosto(){
        return costo;
    }
    
    public String getQualita(){
        return qualita;
    }
}
