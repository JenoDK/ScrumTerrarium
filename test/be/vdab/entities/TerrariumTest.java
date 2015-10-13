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
    private Terrarium terrariumMetP;
    private static final int GROOTTE = 10;
    private static final int AANTAL_PLANTEN = 3;
    private static final int AANTAL_HERBIVOREN = 6;
    private static final int AANTAL_CARNIVOREN = 7;
    private static final int AANTAL_OMNIVOREN = 8;
    private static final int AANTAL_EXTRA_PLANTEN_PER_DAG = 2;

    @Before
    public void before() {
        terrarium = new Terrarium();
        terrariumMetP = new Terrarium(GROOTTE, AANTAL_PLANTEN,
                AANTAL_EXTRA_PLANTEN_PER_DAG, AANTAL_HERBIVOREN,
                AANTAL_CARNIVOREN, AANTAL_OMNIVOREN);
    }

    @Test
    public void nieuwDefaultTerrariumHeeftAlsDag1() {
        Assert.assertEquals(1, terrarium.getDag());
    }

    @Test
    public void nieuwTerrariumMetParametersHeeftAlsDag1() {
        Assert.assertEquals(1, terrariumMetP.getDag());
    }

    @Test
    public void nieuwDefaultTerrariumHeeftAantalOrganismenGelijkAanDeSomVanDeAantallen() {
        int aantalOrganismen = terrarium.getAantalOrganismen();
        int somVanDeAantallenBijInitialiseer = terrarium.getAantalPlanten()
                + terrarium.getAantalHerbivoren()
                + terrarium.getAantalCarnivoren()
                + terrarium.getAantalOmnivoren();
        Assert.assertEquals(aantalOrganismen, somVanDeAantallenBijInitialiseer);
    }

    @Test
    public void nieuwTerrariumMetParametersHeeftAantalOrganismenGelijkAanDeSomVanDeAantallen() {
        int aantalOrganismen = terrariumMetP.getAantalOrganismen();
        int somVanDeAantallenBijInitialiseer = terrariumMetP.getAantalPlanten()
                + terrariumMetP.getAantalHerbivoren()
                + terrariumMetP.getAantalCarnivoren()
                + terrariumMetP.getAantalOmnivoren();
        Assert.assertEquals(aantalOrganismen, somVanDeAantallenBijInitialiseer);
    }

    @Test
    public void nieuwDefaultTerrariumToevoegenVerhoogtHetAantalOrganismenInArrayMet1() {
        int somVanDeAantallenBijInitialiseer = terrarium.getAantalPlanten()
                + terrarium.getAantalHerbivoren()
                + terrarium.getAantalCarnivoren()
                + terrarium.getAantalOmnivoren()+
        1;
         terrarium.organismeToevoegen("plant", 1);
        Assert.assertEquals(somVanDeAantallenBijInitialiseer, terrarium.getAantalOrganismen());
    }
    
    @Test
    public void nieuwTerrariumMetParametersToevoegenVerhoogtHetAantalOrganismenInArrayMet1() {
        int somVanDeAantallenBijInitialiseer = terrariumMetP.getAantalPlanten()
                + terrariumMetP.getAantalHerbivoren()
                + terrariumMetP.getAantalCarnivoren()
                + terrariumMetP.getAantalOmnivoren()+
        1;
         terrariumMetP.organismeToevoegen("plant", 1);
        Assert.assertEquals(somVanDeAantallenBijInitialiseer, terrariumMetP.getAantalOrganismen());
    }

    @Test
    public void nieuwDefaultTerrariumHeeftArrayGelijkAanGrootte() {
        Assert.assertEquals(terrarium.getGrootte(), terrarium.getArray().length);
    }
    
    @Test
    public void nieuwTerrariumMetParametersHeeftArrayGelijkAanGrootte() {
        Assert.assertEquals(terrariumMetP.getGrootte(), terrariumMetP.getArray().length);
    }

    @Test
    public void DefaultTerrariumOrganismeVerwijderenGeeftAltijdNullOpDiePositieNaHetVerwijderen() {
        int x = 0;
        terrarium.organismeVerwijderen(x, x);
        Assert.assertNull(terrarium.getArray()[x][x]);
    }
    
    @Test
    public void terrariumMetParametersOrganismeVerwijderenGeeftAltijdNullOpDiePositieNaHetVerwijderen() {
        int x = 0;
        terrariumMetP.organismeVerwijderen(x, x);
        Assert.assertNull(terrariumMetP.getArray()[x][x]);
    }


    @Test
    public void controleGrensOpGrensGeeftTrue() {
        Assert.assertTrue(terrarium.controleGrens(terrarium.getGrootte() - 1, 0, Richting.OOST));
    }

    @Test
    public void controleGrensOpGrensGeeftFalse() {
        Assert.assertFalse(terrarium.controleGrens(0, 0, Richting.OOST));
    }

    @Test
    public void geefBewegingsMogelijkheidGeeftInstanceOfEnumRichtingTerug() {
        Assert.assertTrue(terrarium.geefBewegingsMogelijkheid(0, 0) instanceof Richting);
    }

    @Test
    public void geefBewegingsMogelijkheidGeeftGeenNoordAanDeBovengrens() {
        Assert.assertFalse(terrarium.geefBewegingsMogelijkheid(0, 0).equals(Richting.NOORD));
    }

    @Test
    public void naHetVerplaatsenIsHandelingGedaan() {
        Herbivoor herbivoor = new Herbivoor();
        terrarium.getArray()[0][0] = herbivoor;
        terrarium.verplaats(0, 0, Richting.OOST);
        Assert.assertTrue(herbivoor.getHandelingGedaan());
    }

}
