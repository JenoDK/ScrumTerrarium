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
        System.out.println("");
        Terrarium terrarium = new Terrarium();
        System.out.println("Dag: " + terrarium.getDag());
        print(terrarium.getArray());
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter is voordoen, s is stoppen");
        String gebruikerInput = scanner.nextLine();
        if (gebruikerInput.equalsIgnoreCase("s")) {
            gebruikerInput = null;
        }
        while (gebruikerInput != null) {
            terrarium.nieuweDag();
            System.out.println("Dag: " + terrarium.getDag());
            print(terrarium.getArray());
            System.out.println("enter is voordoen, s is stoppen");
            gebruikerInput = scanner.nextLine();
            if (gebruikerInput.equalsIgnoreCase("s")) {
                gebruikerInput = null;
            }
        }

    }

    private static void print(Organisme[][] organisme) {
        for (int x = 0; x < organisme.length; x++) {
            for (int y = 0; y < organisme.length; y++) {
                if (organisme[x][y] == null) {
                    System.out.print("  .  ");
                } else if (organisme[x][y] instanceof Plant) {
                    {
                        System.out.print("  P  ");
                    }
                } else if (organisme[x][y] instanceof Carnivoor) {
                    {
                        System.out.print("  C  ");
                    }
                } else if (organisme[x][y] instanceof Herbivoor) {
                    {
                        System.out.print("  H  ");
                    }
                }
            }
            System.out.println("");
        }

    }
}
