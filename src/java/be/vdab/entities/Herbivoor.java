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
public class Herbivoor extends Dier {
    
    

    public Herbivoor() {
        super(0);
        
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
        return "Herbivoor: " + super.toString() ;
    }
}
