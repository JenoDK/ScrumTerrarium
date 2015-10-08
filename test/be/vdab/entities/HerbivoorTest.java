/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class HerbivoorTest {

    private Herbivoor herbivoor;

    @Before
    public void before() {
        herbivoor = new Herbivoor();
    }

    @Test
    public void levenskrachtNieuweHerbivoorIs0() {
        Assert.assertEquals(0, herbivoor.getLevenskracht());

    }
    
    @Test
    public void levenskrachtNaEtenVan1Plant(){
        Plant plant = new Plant();
        herbivoor.eet(plant);
        Assert.assertEquals(1, herbivoor.getLevenskracht());
    }
    @Test
    public void levenskrachtNaEtenVanMeerderePlant(){
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();
        herbivoor.eet(plant1);
        herbivoor.eet(plant2);
        Assert.assertEquals(2, herbivoor.getLevenskracht());
    }
    
    
    
}
