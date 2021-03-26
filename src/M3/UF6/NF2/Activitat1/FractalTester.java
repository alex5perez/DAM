/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.NF2.Activitat1;

import java.util.Scanner;

/**
 *
 * @author alexp
 */
public class FractalTester {
    public static void main(String[] args) {
        Scanner teclat = new Scanner (System.in);
        
        System.out.println("Longitut del quadat mes gran: ");
        int costat = teclat.nextInt();
        int costatGran = costat;
        int quadrats = 1;
        int perimetreTotal = 0;
        
        //Si el els Costats son mes de 1
        while(costatGran >= 1){
            perimetreTotal += calculPerimetre(costatGran, quadrats);
            
            costatGran /= 2;
            quadrats *= 4;
        }
        
        System.out.println("Costats Totals: " + perimetreTotal);
    }
        public static int calculPerimetre(int costatGran, int quadrats){
           return perimetre(costatGran) * quadrats;
        }

        private static int perimetre(int costat) {
            return costat * 4; 
        }

}
