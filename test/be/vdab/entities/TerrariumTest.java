/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;


import be.vdab.valueobjects.Richting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Admin
 */
public class TerrariumTest {
    private Terrarium terrarium;
    
    @Before
    public void before(){
        terrarium = new Terrarium();
    }
    
    @Test
    public void nieuwTerrariumHeeftAlsDag1(){
        Assert.assertEquals(1, terrarium.getDag());
    }
    
    @Test
    public void nieuwTerrariumHeeftAantalOrganismenGelijkAanDeSomVanDeAantallen(){
        int aantalOrganismen = terrarium.getAantalOrganismen();
        int somVanDeAantallenBijInitialiseer = terrarium.getAantalPlanten() + 
                                               terrarium.getAantalHerbivoren() + 
                                               terrarium.getAantalCarnivoren();
        Assert.assertEquals(aantalOrganismen, somVanDeAantallenBijInitialiseer);
    }
    
    @Test
    public void nieuwTerrariumToevoegenVerhoogtHetAantalOrganismenInArrayMet1(){
         int somVanDeAantallenBijInitialiseer = terrarium.getAantalPlanten() + 
                                               terrarium.getAantalHerbivoren() + 
                                               terrarium.getAantalCarnivoren() +
                                               1;
         terrarium.organismeToevoegen("plant", 1);
         Assert.assertEquals(somVanDeAantallenBijInitialiseer, terrarium.getAantalOrganismen());
    }
    
    @Test
    public void nieuwTerrariumHeeftArrayGelijkAanGrootte(){
        Assert.assertEquals(terrarium.getGrootte(), terrarium.getArray().length);
    }
    
    @Test
    public void organismeVerwijderenGeeftAltijdNullOpDiePositieNaHetVerwijderen(){
        int x = 0;
        terrarium.organismeVerwijderen(x, x);
        Assert.assertNull(terrarium.getArray()[x][x]);
    }
    
//    @Test
//    public void controleRechtsGeeftHetJuisteObjectTerug(){
//        Plant plant = new Plant();
//        terrarium.getArray()[1][0] = plant;
//        Assert.assertEquals(plant, terrarium.getArray()[1][0]);
//    }
    
    @Test
    public void controleGrensOpGrensGeeftTrue(){
        Assert.assertTrue(terrarium.controleGrens(terrarium.getGrootte()-1, 0, Richting.OOST));
    }
    
    @Test
    public void controleGrensOpGrensGeeftFalse(){
        Assert.assertFalse(terrarium.controleGrens(0, 0, Richting.OOST));
    }
    
    @Test
    public void geefBewegingsMogelijkheidGeeftInstanceOfEnumRichtingTerug(){
        Assert.assertTrue(terrarium.geefBewegingsMogelijkheid(0,0) instanceof Richting);
    }
    
    @Test
    public void geefBewegingsMogelijkheidGeeftGeenNoordAanDeBovengrens(){
        Assert.assertFalse(terrarium.geefBewegingsMogelijkheid(0,0).equals(Richting.NOORD));
    }
    
    @Test
    public void naHetVerplaatsenIsHandelingGedaan(){
        Herbivoor herbivoor = new Herbivoor();
        terrarium.getArray()[0][0] = herbivoor;
        terrarium.verplaats(0, 0, Richting.OOST);
        Assert.assertTrue(herbivoor.getHandelingGedaan());
    }
    
}
