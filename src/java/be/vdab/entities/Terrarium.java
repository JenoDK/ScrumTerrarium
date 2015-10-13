/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

import be.vdab.valueobjects.Richting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Terrarium {

    private static final int DEFAULT_GROOTTE = 6, DEFAULT_AANTAL_EXTRA_PLANTEN_PER_DAG = 2,
            DEFAULT_AANTAL_PLANTEN = 2, DEFAULT_AANTAL_HERBIVOREN = 4, DEFAULT_AANTAL_CARNIVOREN = 6,
            DEFAULT_AANTAL_OMNIVOREN = 6;
    private int grootte, aantalExtraPlantenPerDag, aantalPlanten, aantalHerbivoren, aantalCarnivoren, aantalOmnivoren;
    private final Organisme[][] array;
    private int aantalHerbivorenToevoegen;
    private int dag = 1;

    //constructor
    public Terrarium() {
        grootte = DEFAULT_GROOTTE;
        aantalExtraPlantenPerDag = DEFAULT_AANTAL_EXTRA_PLANTEN_PER_DAG;
        aantalPlanten = DEFAULT_AANTAL_PLANTEN;
        aantalHerbivoren = DEFAULT_AANTAL_HERBIVOREN;
        aantalCarnivoren = DEFAULT_AANTAL_CARNIVOREN;
        aantalOmnivoren = DEFAULT_AANTAL_OMNIVOREN;
        array = new Organisme[grootte][grootte];
        initialiseer();
    }

    public Terrarium(int grootte, int aantalPlanten, int aantalExtraPlantenPerDag, int aantalHerbivoren, int aantalCarnivoren, int aantalOmnivoren) {
        this.grootte = grootte;
        this.array = new Organisme[grootte][grootte];
        this.aantalExtraPlantenPerDag = aantalExtraPlantenPerDag;
        this.aantalPlanten = aantalPlanten;
        this.aantalHerbivoren = aantalHerbivoren;
        this.aantalCarnivoren = aantalCarnivoren;
        this.aantalOmnivoren = aantalOmnivoren;
        initialiseer();
    }

    //getters
    public int getGrootte() {
        return grootte;
    }

    public int getDag() {
        return dag;
    }

    public Organisme[][] getArray() {
        return array;
    }

    public int getAantalPlanten() {
        return aantalPlanten;
    }

    public int getAantalHerbivoren() {
        return aantalHerbivoren;
    }

    public int getAantalCarnivoren() {
        return aantalCarnivoren;
    }

    public int getAantalOmnivoren() {
        return aantalOmnivoren;
    }
    
    

    //setters
    public void setDag(int dag) {
        this.dag = dag;
    }

    public void setAantalExtraPlantenPerDag(int aantalExtraPlantenPerDag) {
        this.aantalExtraPlantenPerDag = aantalExtraPlantenPerDag;
    }

    public void setAantalPlanten(int aantalPlanten) {
        this.aantalPlanten = aantalPlanten;
    }

    public void setAantalHerbivoren(int aantalHerbivoren) {
        this.aantalHerbivoren = aantalHerbivoren;
    }

    public void setAantalCarnivoren(int aantalCarnivoren) {
        this.aantalCarnivoren = aantalCarnivoren;
    }

    public void setAantalOmnivoren(int aantalOmnivoren) {
        this.aantalOmnivoren = aantalOmnivoren;
    }
    
    

    /**
     * Indien we grootte moeten aanpassen
     *
     */
//    public void setGrootte(int grootte){
//        this.grootte = grootte;
//    }
    /**
     * 1e maal array aanmaken
     *
     */
    public final void initialiseer() {
        organismeToevoegen("plant", aantalPlanten);
        organismeToevoegen("carnivoor", aantalCarnivoren);
        organismeToevoegen("herbivoor", aantalHerbivoren);
        organismeToevoegen("omnivoor", aantalOmnivoren);
    }

    public boolean plaatsIsVrij(int x, int y) {
        return array[x][y] == null;
    }

    public void organismeToevoegen(String soort, int aantal) {
        Random r = new Random();
        for (int i = 0; i < aantal; i++) {
            int x = r.nextInt(grootte);
            int y = r.nextInt(grootte);
            boolean isVrij = plaatsIsVrij(x, y);
            while (!isVrij) {
                x = r.nextInt(grootte);
                y = r.nextInt(grootte);
                isVrij = plaatsIsVrij(x, y);
            }
            if (soort.equals("plant")) {
                array[x][y] = new Plant();
            }
            else if (soort.equals("carnivoor")) {
                array[x][y] = new Carnivoor();
            }
            else if (soort.equals("herbivoor")) {
                array[x][y] = new Herbivoor();
            }
            else if (soort.equals("omnivoor")) {
                array[x][y] = new Omnivoor();
            }

        }
    }

    public void organismeVerwijderen(int x, int y) {
        array[x][y] = null;
    }

    public void nieuweDag() {
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] instanceof Organisme) {
                    array[x][y].setHandelingGedaan(false);
                }
            }
        }
        ++dag;
        if (getAantalOrganismen() <= grootte * grootte - aantalExtraPlantenPerDag) {
            organismeToevoegen("plant", aantalExtraPlantenPerDag);
        }
        stappenHerbivoor();
        if (getAantalOrganismen() <= grootte * grootte - aantalHerbivorenToevoegen) {
            organismeToevoegen("herbivoor", aantalHerbivorenToevoegen);
        }
        stappenCarnivoor();
        stappenOmnivoor();

    }

    /**
     * actie die herbivoren kunnen doen + indien nodig verplaats
     *
     */
    public void stappenHerbivoor() {
        aantalHerbivorenToevoegen = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] instanceof Herbivoor && !array[x][y].getHandelingGedaan()) {
                    if (controleGrens(x, y, Richting.OOST) == false) {
                        if (array[x + 1][y] instanceof Plant) {
                            array[x][y].setLevenskracht(
                                    array[x + 1][y].getLevenskracht()
                                    + array[x][y].getLevenskracht());
                            organismeVerwijderen(x + 1, y);
                            verplaats(x, y, Richting.OOST);
                        } else if (array[x + 1][y] instanceof Herbivoor) {
                            aantalHerbivorenToevoegen++;
                            array[x][y].setHandelingGedaan(true);
                        } else {
                            Richting richting = geefBewegingsMogelijkheid(x, y);
                            verplaats(x, y, richting);
                        }
                    } else {
                        Richting richting = geefBewegingsMogelijkheid(x, y);
                        verplaats(x, y, richting);
                    }
                }
            }
        }
    }

    /**
     * actie die Carnivoren kunnen doen + indien nodig verplaats
     *
     */
    public void stappenCarnivoor() {

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] instanceof Carnivoor && !array[x][y].getHandelingGedaan()) {
                    if (controleGrens(x, y, Richting.OOST) == false) {
                        if (array[x + 1][y] instanceof Herbivoor) {

                            array[x][y].setLevenskracht(
                                    array[x + 1][y].getLevenskracht()
                                    + array[x][y].getLevenskracht());
                            organismeVerwijderen(x + 1, y);
                            array[x][y].setHandelingGedaan(true);
                        } else if (array[x + 1][y] instanceof Carnivoor) {
                            Carnivoor carnivoor = (Carnivoor) array[x][y];
                            Carnivoor tegenstander = (Carnivoor) array[x + 1][y];
                            carnivoor.vechten(tegenstander);
                            array[x][y].setHandelingGedaan(true);
                            if (carnivoor.getLevenskracht() == 0) {
                                organismeVerwijderen(x, y);
                            }
                            if (tegenstander.getLevenskracht() == 0) {
                                organismeVerwijderen(x + 1, y);
                            }
                        } else {
                            Richting richting = geefBewegingsMogelijkheid(x, y);
                            verplaats(x, y, richting);
                        }
                    } else {
                        Richting richting = geefBewegingsMogelijkheid(x, y);
                        verplaats(x, y, richting);
                    }
                }
            }
        }
    }

    public void stappenOmnivoor() {
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] instanceof Omnivoor && !array[x][y].getHandelingGedaan()) {
                    if (controleGrens(x, y, Richting.OOST) == false) {
                        if (array[x + 1][y] instanceof Herbivoor) {
                            array[x][y].setLevenskracht(array[x + 1][y].getLevenskracht() + array[x][y].getLevenskracht());
                            organismeVerwijderen(x + 1, y);
                            array[x][y].setHandelingGedaan(true);
                        } else if (array[x + 1][y] instanceof Carnivoor || array[x + 1][y] instanceof Omnivoor) {
                            Omnivoor omnivoor = (Omnivoor) array[x][y];                            
                            omnivoor.vechten(array[x + 1][y]);
                            array[x][y].setHandelingGedaan(true);
                            if (array[x][y].getLevenskracht() == 0) {
                                organismeVerwijderen(x, y);
                            }
                            if (array[x+1][y].getLevenskracht() == 0) {
                                organismeVerwijderen(x + 1, y);
                            }
                        } else if (array[x + 1][y] instanceof Plant) {
                            array[x][y].setLevenskracht(array[x + 1][y].getLevenskracht() + array[x][y].getLevenskracht());
                            organismeVerwijderen(x + 1, y);
                            verplaats(x, y, Richting.OOST);
                        } else {
                            Richting richting = geefBewegingsMogelijkheid(x, y);
                            verplaats(x, y, richting);
                        }
                    } else {
                        Richting richting = geefBewegingsMogelijkheid(x, y);
                        verplaats(x, y, richting);
                    }
                }
            }
        }
    }

    /**
     * Methode controleert de verschillende mogelijke beweegrichtingen en geeft
     * daar 1 van als returnwaarde
     *
     * @param x
     * @param y
     * @return
     */
    public Richting geefBewegingsMogelijkheid(int x, int y) {
        ArrayList<Richting> mogelijkheden = new ArrayList<>();
        Richting resultaat;
        if (!controleGrens(x, y, Richting.OOST) && plaatsIsVrij(x + 1, y)) {
            mogelijkheden.add(Richting.OOST);
        }
        if (!controleGrens(x, y, Richting.WEST) && plaatsIsVrij(x - 1, y)) {
            mogelijkheden.add(Richting.WEST);
        }
        if (!controleGrens(x, y, Richting.ZUID) && plaatsIsVrij(x, y + 1)) {
            mogelijkheden.add(Richting.ZUID);
        }
        if (!controleGrens(x, y, Richting.NOORD) && plaatsIsVrij(x, y - 1)) {
            mogelijkheden.add(Richting.NOORD);
        }
        if (!mogelijkheden.isEmpty()) {
            Random r = new Random();
            int keuze = r.nextInt(mogelijkheden.size());
            resultaat = mogelijkheden.get(keuze);
        } else {
            resultaat = Richting.OMSINGELD;
        }
        return resultaat;
    }

    public void verplaats(int x, int y, Richting richting) {

        int rij = y;
        int kolom = x;
        if (richting == Richting.NOORD) {
            rij--;
        } else if (richting == Richting.ZUID) {
            rij++;
        } else if (richting == Richting.OOST) {
            kolom++;
        } else if (richting == Richting.WEST) {
            kolom--;
        } else if (richting == Richting.OMSINGELD) {
        }
        array[kolom][rij] = array[x][y];
        if (richting != Richting.OMSINGELD) {
            array[x][y] = null;
        }
        array[kolom][rij].setHandelingGedaan(true);
    }

    public boolean controleGrens(int x, int y, Richting richting) {

        if (Richting.NOORD == richting & y == 0) {
            return true;
        }
        if (Richting.ZUID == richting & y == grootte - 1) {
            return true;
        }
        if (Richting.OOST == richting & x == grootte - 1) {
            return true;
        }
        if (Richting.WEST == richting & x == 0) {
            return true;
        }
        return false;
    }

    public int getAantalOrganismen() {
        int aantalOrganismen = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (array[x][y] instanceof Organisme) {
                    aantalOrganismen++;
                }
            }
        }
        return aantalOrganismen;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.deepHashCode(this.array);
        hash = 29 * hash + this.dag;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terrarium other = (Terrarium) obj;
        if (!Arrays.deepEquals(this.array, other.array)) {
            return false;
        }
        if (this.dag != other.dag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Terrarium{" + "dag = " + dag + " grootte = " + grootte + " aantal organismen = " + getAantalOrganismen() + '}';
    }

}
