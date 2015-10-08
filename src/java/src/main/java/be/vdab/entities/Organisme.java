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
public abstract class Organisme {
    
    private int levenskracht;

    public Organisme(int levenskracht) {
        this.levenskracht = levenskracht;
    }

    public int getLevenskracht() {
        return levenskracht;
    }

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

    
    
    
    
    
    
}
