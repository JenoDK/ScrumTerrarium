/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.services;

import be.vdab.entities.Terrarium;

/**
 *
 * @author Admin
 */
public class SpelService {
    
    private Terrarium terrarium;
    
    public SpelService(){
        this.terrarium = new Terrarium();
    }
    
    public SpelService(int hierKomenDeParameters){
        this.terrarium = new Terrarium(/*parameters*/);
    }

    public Terrarium getTerrarium() {
        return terrarium;
    }
    
    public void nieuweDag(){
        this.terrarium.nieuweDag();
    }
    
}
