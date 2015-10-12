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
        int aantalOrganismen = terrarium.geefAantalOrganismen();
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
         Assert.assertEquals(somVanDeAantallenBijInitialiseer, terrarium.geefAantalOrganismen());
    }
    
    @Test
    public void nieuwTerrariumHeeftArrayGelijkAanGrootte(){
        Assert.assertEquals(terrarium.getGrootte(), terrarium.getArray().length);
    }
    
    @Test
    public void organismeVerwijderenGeeftAltijdNullOpDiePositieNaHetVerwijderen(){
        int x = terrarium.getGrootte();
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
    public void controleGrensOpGrensGeeftFalse(){
        Assert.assertFalse(terrarium.controleGrens(6, 0, Richting.OOST));
    }
    
    
    
}
