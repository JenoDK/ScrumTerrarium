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
    
    @Test
   public void toStringMethodeTestCarnivoor(){
       Assert.assertEquals("Plant: 1", plant.toString());
   }
   
   @Test
   public void tegenstanderIsNietGelijkAanCarnivoor(){
       Plant bellsprout = new Plant();
       Assert.assertNotSame(bellsprout,plant);
   }
   
   @Test
   public void carnivoorIsHetzelfdeAlsZichzelf(){
       Assert.assertSame(plant, plant);
   }
   
   @Test
   public void plantNietHetzelfdeAlsHerbivoor(){
       Herbivoor bulbasaur = new Herbivoor();
       Assert.assertNotSame(plant, bulbasaur);
   }
   
   @Test
   public void plantNietHetzelfdeAlsCarnivoor(){
       Carnivoor charmander = new Carnivoor();
       Assert.assertNotSame(plant, charmander);
   }
   
   @Test
   public void hashCodeMagNietHetzelfdeZijnVanVerschillendePlanten(){
       Plant plant2 = new Plant();
       Assert.assertFalse(plant2.hashCode() == plant.hashCode());
   }
   
   @Test
   public void hashCodeMoetHetzelfdeZijnVandezelfdePlanten(){
       Assert.assertEquals(plant.hashCode(), plant.hashCode());
   }
}
