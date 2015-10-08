/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.entities.Terrarium;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here aaaa
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
