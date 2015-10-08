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
public abstract class Dier extends Organisme{

    public Dier(int levenskracht) {
        super(levenskracht);
    }
    
    public void verhoogLevenskracht(int levenskrachtAnderOrganisme){
        setLevenskracht(getLevenskracht() + levenskrachtAnderOrganisme);
    }
    
    public void eet(Organisme organisme){
        verhoogLevenskracht(organisme.getLevenskracht());
    };
    
    
    
    
}
