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
    
    public void compra(Dessert d){
        
    }
}
