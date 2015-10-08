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
public class Carnivoor extends Dier {
    
    public Carnivoor() {        
        super(1);
    }
    
    /**
     * Zal 2 carnivoren virtueel met elkaar laten vechten waarbij de carnivoor met de meeste levenskracht wint 
     * 
     * @param tegenstander 
     */
    public void vechten(Carnivoor tegenstander) {
        if (this.getLevenskracht() > tegenstander.getLevenskracht()) {
            this.verhoogLevenskracht(tegenstander.getLevenskracht());
        }
        if (this.getLevenskracht() < tegenstander.getLevenskracht()) {
            tegenstander.verhoogLevenskracht(this.getLevenskracht());
        }
        
    }
    
}
