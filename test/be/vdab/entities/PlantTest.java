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
public class PlantTest {
    private Plant plant;
    
   
    @Before
    public void before() {
        plant = new Plant();
    }
   
    @Test
    public void levenskrachtVanEenPlantIs1() {
    Assert.assertEquals(1, plant.getLevenskracht());
    }
}
