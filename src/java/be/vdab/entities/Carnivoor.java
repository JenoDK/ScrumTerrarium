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
public class Carnivoor extends Dier{
    
    public Carnivoor() {        
        super(1);
    }
    
    
    
    /**
     * Zal 2 carnivoren virtueel met elkaar laten vechten waarbij de carnivoor met de meeste levenskracht wint 
     * 
     * @param tegenstander 
     */
    public void vechten(Organisme tegenstander) {
        if (this.getLevenskracht() > tegenstander.getLevenskracht()) {
            this.verhoogLevenskracht(tegenstander.getLevenskracht());
            tegenstander.setLevenskracht(0);
        }
        if (this.getLevenskracht() < tegenstander.getLevenskracht()) {
            tegenstander.setLevenskracht(this.getLevenskracht() + tegenstander.getLevenskracht());
            this.setLevenskracht(0);
        }
        
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
        return "Carnivoor: " + super.toString() ;
    }

    
    
    
    
    
}
