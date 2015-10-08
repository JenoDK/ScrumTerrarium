/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.be.vdab.entities;

/**
 *
 * @author Admin
 */
public class Carnivoor extends Dier{

    public Carnivoor(int levenskracht) {
        super(levenskracht);
    }
    
    public void vechten(Carnivoor tegenstander){
        verhoogLevenskracht(tegenstander.getLevenskracht());
    }
    
}
