/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

import be.vdab.valueobjects.Richting;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Terrarium {

    private static final int grootte = 6, aantalExtraPlantenPerDag = 2,
            aantalPlanten = 2, aantalHerbivoren = 4, aantalCarnivoren = 6;
    private Organisme[][] array = new Organisme[grootte][grootte];
    private int dag, aantalHerbivorenToevoegen;

    //constructor
    public Terrarium() {
        setDag(1);
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

    //setters
    public void setDag(int dag) {
        this.dag = dag;
    }

    /**
     * Indien we grootte moeten aanpassen
     *
     */
//    public void setGrootte(int grootte){
//        this.grootte = grootte;
//    }
    public void initialiseer() {
        organismeToevoegen("plant", aantalPlanten);
        organismeToevoegen("carnivoor", aantalCarnivoren);
        organismeToevoegen("herbivoor", aantalHerbivoren);
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
            if (soort.equals("carnivoor")) {
                array[x][y] = new Carnivoor();
            }
            if (soort.equals("herbivoor")) {
                array[x][y] = new Herbivoor();
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
        organismeToevoegen("plant", aantalExtraPlantenPerDag);
        stappenHerbivoor();
        organismeToevoegen("herbivoor", aantalHerbivorenToevoegen);
        stappenCarnivoor();

    }

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
                            array[x + 1][y].setHandelingGedaan(true);
                        } else if (array[x + 1][y] instanceof Herbivoor) {
                            aantalHerbivorenToevoegen++;
                            array[x][y].setHandelingGedaan(true);
                        } else {
                            Richting richting = geefBewegingsMogelijkheid(x, y);
                            if (richting != Richting.OMSINGELD) {
                                verplaats(x, y, richting);
                            }
                        }
                    }
                }
            }
        }

    }

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
                            verplaats(x, y, Richting.OOST);
                            array[x + 1][y].setHandelingGedaan(true);
                        } else if (array[x + 1][y] instanceof Carnivoor) {
                            Carnivoor carnivoor = (Carnivoor) array[x][y];
                            Carnivoor tegenstander = (Carnivoor) array[x + 1][y];
                            carnivoor.vechten(tegenstander);
                            if (carnivoor.getLevenskracht() == 0){
                                organismeVerwijderen(x, y);
                            }
                            if (tegenstander.getLevenskracht() == 0){
                                organismeVerwijderen(x + 1, y);
                            }
                            array[x][y].setHandelingGedaan(true);
                        } else {
                            Richting richting = geefBewegingsMogelijkheid(x, y);
                            if (richting != Richting.OMSINGELD) {
                                verplaats(x, y, richting);
                            }
                        }
                    }
                }
            }
        }

    }

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
        }
        array[kolom][rij] = array[x][y];
        array[x][y] = null;
        System.out.println("Organisme op plaats "+x+" "+y+" beweegt naar plaats "+kolom+" "+rij);
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
                if (array[x][y] instanceof Herbivoor || array[x][y] instanceof Plant || array[x][y] instanceof Carnivoor) {
                    aantalOrganismen++;
                }
            }
        }
        return aantalOrganismen;
    }
}
