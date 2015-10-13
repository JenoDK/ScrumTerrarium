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
    
    public SpelService(int grootte, int aantalPlanten, int aantalExtraPlantenPerDag, int aantalHerbivoren, int aantalCarnivoren, int aantalOmnivoren){
        this.terrarium = new Terrarium(grootte, aantalPlanten, aantalExtraPlantenPerDag, aantalHerbivoren, aantalCarnivoren, aantalOmnivoren);
    }

    public Terrarium getTerrarium() {
        return terrarium;
    }
    
    public void nieuweDag(){
        this.terrarium.nieuweDag();
    }
    
}
