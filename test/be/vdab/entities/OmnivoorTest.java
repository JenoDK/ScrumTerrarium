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
 * @author admin
 */
public class OmnivoorTest {
    private Omnivoor omnivoor;
    
    @Before
    public void before(){
        omnivoor = new Omnivoor();
    }  
    
   @Test
   public void nieuweOmnivoorHeeft1AlsLevenIsJuist() {
       Assert.assertEquals(1, omnivoor.getLevenskracht());
   }
    
   @Test
   public void omnivoorZijnNieuwLevenNaVechtenTegenSterkereTegenstanderOmnivoor(){
       Omnivoor tegenstander = new Omnivoor();
       tegenstander.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(0, omnivoor.getLevenskracht());
       
   } 
   
   @Test
   public void omnivoorZijnNieuwLevenNaVechtenTegenZwakkereTegenstanderOmnivoor(){
       Omnivoor tegenstander = new Omnivoor();
       omnivoor.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(4, omnivoor.getLevenskracht());

   }
   
   @Test
   public void omnivoorZijnNieuwLevenNaVechtenTegenSterkereTegenstanderCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();
       tegenstander.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(0, omnivoor.getLevenskracht());
       
   } 
   
   @Test
   public void omnivoorZijnNieuwLevenNaVechtenTegenZwakkereTegenstanderCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();
       omnivoor.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(4, omnivoor.getLevenskracht());

   }
   
   @Test
   public void tegenstanderZijnNieuwLevenNaEtenZwakkereCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();    
       tegenstander.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(4, tegenstander.getLevenskracht());
   }
   
   @Test
   public void tegenstanderZijnNieuwLevenNaEtenZwakkereOmnivoor(){
       Omnivoor tegenstander = new Omnivoor();    
       tegenstander.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(4, tegenstander.getLevenskracht());
   }
   
   @Test
   public void tegenstanderZijnNieuwLevenNaEtenSterkereCarnivoor(){
       Carnivoor tegenstander = new Carnivoor();
       omnivoor.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(0, tegenstander.getLevenskracht());
   }
   
   @Test
   public void tegenstanderZijnNieuwLevenNaEtenSterkereOmnivoor(){
       Omnivoor tegenstander = new Omnivoor();
       omnivoor.setLevenskracht(3);
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(0, tegenstander.getLevenskracht());
   }
   
   @Test
   public void omnivoorZijnLevensKrachtNaEtenHerbivoor(){
       Herbivoor herbivoor = new Herbivoor();
       herbivoor.setLevenskracht(3);
       omnivoor.eet(herbivoor);
       Assert.assertEquals(4, omnivoor.getLevenskracht());
   }
   
   @Test
   public void OmnivoorZijnLevensKrachtNaEtenNieuweHerbivoor(){
       Herbivoor herbivoor = new Herbivoor();
       omnivoor.eet(herbivoor);
       Assert.assertEquals(1, omnivoor.getLevenskracht());
   }
   
   @Test
   public void levenskrachtOmnivoorNaVechtenEvenSterkteTegenstander(){
       Omnivoor tegenstander = new Omnivoor();
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(1, omnivoor.getLevenskracht());
   }
   
   @Test
   public void levenskrachtTegenstanderNaVechtenEvenSterkteCarnivoor(){
       Omnivoor tegenstander = new Omnivoor();
       omnivoor.vechten(tegenstander);
       Assert.assertEquals(1, tegenstander.getLevenskracht());
   }
   @Test
    public void levenskrachtNaEtenVan1Plant(){
        Plant plant = new Plant();
        omnivoor.eet(plant);
        Assert.assertEquals(2, omnivoor.getLevenskracht());
    }
    @Test
    public void levenskrachtNaEtenVanMeerderePlant(){
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();
        omnivoor.eet(plant1);
        omnivoor.eet(plant2);
        Assert.assertEquals(3, omnivoor.getLevenskracht());
    }
   
   @Test
   public void toStringMethodeTestOmnivoor(){
       Assert.assertEquals("Omnivoor: 1", omnivoor.toString());
   }
   
    @Test
   public void tegenstanderIsNietGelijkAanOmnivoor(){
       Omnivoor tegenstander = new Omnivoor();
       Assert.assertNotSame(tegenstander,omnivoor);
   }
   
   @Test
   public void omnivoorIsHetzelfdeAlsZichzelf(){
       Assert.assertSame(omnivoor, omnivoor);
   }
   
   @Test
   public void hashCodeMagNietHetzelfdeZijnVanVerschillendeOmnivoren(){
       Omnivoor charmander = new Omnivoor();
       Assert.assertFalse(charmander.hashCode()==omnivoor.hashCode());       
   }
   
    @Test
   public void hashCodeMoetHetzelfdeZijnVandezelfdeOmnivoren(){
       Assert.assertEquals(omnivoor.hashCode(), omnivoor.hashCode());
   }
   
}
