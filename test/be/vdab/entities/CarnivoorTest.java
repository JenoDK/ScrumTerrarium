/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class CarnivoorTest {
    private Carnivoor carnivoor;

    
    @Before
    public void before(){
        carnivoor = new Carnivoor();
    }


   @Test
   public void nieuweCarnivoorHeeft1AlsLevenIsJuist() {
       Assert.assertEquals(1, carnivoor.getLevenskracht());
   }
   
   @Test
   public void carnivoorZijnNieuwLevenNaVechtenTegenSterkereTegenstander(){
       Carnivoor tegenstander = new Carnivoor();
       tegenstander.setLevenskracht(3);
       carnivoor.vechten(tegenstander);
       Assert.assertEquals(0, carnivoor.getLevenskracht());
       
   }
   
      @Test
   public void carnivoorZijnNieuwLevenNaVechtenTegenZwakkereTegenstander(){
       Carnivoor tegenstander = new Carnivoor();
       carnivoor.setLevenskracht(3);
       carnivoor.vechten(tegenstander);
       Assert.assertEquals(4, carnivoor.getLevenskracht());

   }
   @Test
   public void tegenstanderZijnNieuwLevenNaEtenZwakkereCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();    
       tegenstander.setLevenskracht(3);
       carnivoor.vechten(tegenstander);
       Assert.assertEquals(4, tegenstander.getLevenskracht());
   }
   
    @Test
   public void tegenstanderZijnNieuwLevenNaEtenSterkereCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();
       carnivoor.setLevenskracht(3);
       carnivoor.vechten(tegenstander);
       Assert.assertEquals(0, tegenstander.getLevenskracht());
   }
   
   @Test
   public void carnivoorZijnLevensKrachtNaEtenHerbivoor(){
       Herbivoor herbivoor = new Herbivoor();
       herbivoor.setLevenskracht(3);
       carnivoor.eet(herbivoor);
       Assert.assertEquals(4, carnivoor.getLevenskracht());
   }
}
