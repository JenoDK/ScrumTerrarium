package be.vdab;

import be.vdab.entities.Carnivoor;
import be.vdab.entities.Herbivoor;
import be.vdab.entities.Organisme;
import be.vdab.entities.Plant;
import be.vdab.entities.Terrarium;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("******Terrarium Simulatie******");
        System.out.println();
        Terrarium terrarium = new Terrarium();
         String gebruikerInput = printHoofdingEnInput(terrarium);  
        while (!gebruikerInput.equalsIgnoreCase("s")) {
            terrarium.nieuweDag();
             gebruikerInput = printHoofdingEnInput(terrarium);            
        }
    }

    private static void print(Organisme[][] organisme) {
        for (int y = 0; y < organisme.length; y++) {
            for (int x = 0; x < organisme.length; x++) {
                if (organisme[x][y] == null) {
                    System.out.print(". \t" );
                } else if (organisme[x][y] instanceof Plant) {
                    {
                        System.out.print("P " + 
                                /*organisme[x][y].getLevenskracht() + */ "\t");
                    }
                } else if (organisme[x][y] instanceof Carnivoor) {
                    {
                        System.out.print("C " +  
                                /*organisme[x][y].getLevenskracht() + */ "\t");
                    }
                } else if (organisme[x][y] instanceof Herbivoor) {
                    {
                        System.out.print("H " +
                                /*organisme[x][y].getLevenskracht() + */ "\t");
                    }
                }
            }
            System.out.println();
        }
    }
    
    private static String printHoofdingEnInput(Terrarium terrarium){
        System.out.println("Dag: " + terrarium.getDag());
        print(terrarium.getArray());
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter is voordoen, s is stoppen");
        String gebruikerInput = scanner.nextLine();
        return gebruikerInput;
    }
}
