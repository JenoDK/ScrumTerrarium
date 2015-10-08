
package src.main.java.be.vdab;

import java.util.Scanner;
import src.main.java.be.vdab.entities.Terrarium;


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

    private static void print(Terrarium[][] terrarium) {
        for (int x = 0; x < terrarium.length; x++) {
            for (int y = 0; y < terrarium.length; y++) {
                System.out.print(terrarium[x][y]);
            }
            System.out.println();
        }
    }

}
