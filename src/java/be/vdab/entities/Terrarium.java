/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

/**
 *
 * @author Admin
 */
public class Terrarium {
   private int grootte=6;
   private static final int aantalPlanten=2,aantalHerbivoren=4,aantalCarnivoren=6;
   private int [][] array = new int[grootte][grootte];
   private int dag;
   
   //constructor

   public Terrarium(){
       
   }
    public Terrarium(int dag) {
        setDag(dag);
    }
    
    //getters

    public int getGrootte() {
        return grootte;
    }

    public static int getAantalPlanten() {
        return aantalPlanten;
    }

    public static int getAantalHerbivoren() {
        return aantalHerbivoren;
    }

    public static int getAantalCarnivoren() {
        return aantalCarnivoren;
    }

    public int getDag() {
        return dag;
    }
    
    //setters

    public void setDag(int dag) {
        this.dag = dag;
    }
    
    
   
}
