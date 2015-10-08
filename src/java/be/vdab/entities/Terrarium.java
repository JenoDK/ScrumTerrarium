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
   private static final  int grootte=6;
   private static final int aantalPlanten=2,aantalHerbivoren=4,aantalCarnivoren=6;
   private Organisme [][] array = new Organisme[grootte][grootte];
   private int dag;
   
   //constructor

   
    public Terrarium() {
        setDag(1);
        initialiseer();
    }
    
    //getters

    public int getGrootte() {
        return grootte;
    }


    public int getDag() {
        return dag;
    }

    public Organisme[][] getArray() {
        return array;
    }
    
    
    //setters

    public void setDag(int dag) {
        this.dag = dag;
    }
    
    public void initialiseer(){
        organismeToevoegen("plant",aantalPlanten );
        organismeToevoegen("carnivoren", aantalCarnivoren );
        organismeToevoegen("Herbivoor", aantalHerbivoren);
    }
    public boolean plaatsIsVrij(int x, int y){
        return array[x][y] == null;
    }
    
    
    public void organismeToevoegen(String soort, int aantal){
        
    }
   
}
