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

    private static final int grootte = 6;
    private static final int aantalPlanten = 2, aantalHerbivoren = 4, aantalCarnivoren = 6;
    private static final int aantalExtraPlantenPerDag = 2;
    private Organisme[][] array = new Organisme[grootte][grootte];
    private int dag;

    //constructor
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
            } else if (soort.equals("carnivoor")) {
                array[x][y] = new Carnivoor();
            } else if (soort.equals("herbivoor")) {
                array[x][y] = new Herbivoor();
            }

        }
    }

    public void organismeVerwijderen(int x, int y) {
        array[x][y] = null;
    }

    public void nieuweDag() {
        organismeToevoegen("plant", aantalExtraPlantenPerDag);
        stappenHerbivoor();
        stappenCarnivoor();
        dag++;
    }
    public void stappenHerbivoor(){
        for(int x=0; x<array.length;x++){
            for (int y = 0; y < array.length; y++) {
                if(array[x][y] instanceof Herbivoor){
                  if(controleerRechts(x,y) instanceof Organisme){
                      
                  }else{
                      Richting richting=geefBewegingsMogelijkheid(x,y);
                      if(richting!=Richting.OMSINGELD){
                      verplaats(x,y,richting);}
                  }  
                }
            }
        }
        
    }

    public void stappenCarnivoor() {

    }

    public Richting geefBewegingsMogelijkheid(int x, int y) {
        ArrayList<Richting> mogelijkheden = new ArrayList<>();
        Richting resultaat;
        if (plaatsIsVrij(x + 1, y)) {
            mogelijkheden.add(Richting.OOST);
        }
        if (plaatsIsVrij(x - 1, y)) {
            mogelijkheden.add(Richting.WEST);
        }
        if (plaatsIsVrij(x, y + 1)) {
            mogelijkheden.add(Richting.ZUID);
        }
        if (plaatsIsVrij(x, y - 1)) {
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

    private Object controleerRechts(int rij, int kolom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void verplaats(int x, int y, Richting richting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean controleGrens(int x,int y,Richting Richting){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Richting geefBewegingsMogelijkheid(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
