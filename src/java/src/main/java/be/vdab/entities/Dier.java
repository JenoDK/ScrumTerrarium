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
public abstract class Dier extends Organisme{

    public Dier(int levenskracht) {
        super(levenskracht);
    }
    
    public void verhoogLevenskracht(int aantal){
        setLevenskracht(getLevenskracht() + aantal);
    }
    
    public void eet(Organisme organisme){
        verhoogLevenskracht(organisme.getLevenskracht());
    };
    
    
    
    
}
