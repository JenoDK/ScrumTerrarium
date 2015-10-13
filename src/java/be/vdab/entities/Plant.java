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
public class Plant extends Organisme {
    
    private int leeftijd;

    public Plant() {
        super(1);
        leeftijd = 1;
    }
    
    public int getLeeftijd() {
        return leeftijd;
    }

    public void verjaar(){
        leeftijd ++;
    }
    
       @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
       @Override
    public String toString() {
        return "Plant: " + super.toString() ;
    }
    
}
