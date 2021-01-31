/*
Heu d’implementar l’algoritme d’ordenació d’un array pel mètode de la 
bombolla i s’ha d’anar anotant per la sortida estàndard els canvis que s’hi 
fan durant l’execució.
 */
package M9.UF2.Activitat4;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
* File: Exercici9UF2M9.java 
* Author: Alex Pérez Rubio i Hector Garzon Borras
* Date: 26-01-2021
* Description: Activitat 4 PRACTICA UF2 M9
*/
public class apartat2 {
       
    static int[] array = {0, 0, 0, 0};
    
    public static void main(String[] args) {
        
        int[] numRandom = new int[20];
        int numeros = (9 - 1);
        int grupAux;
                
        NumeroBombolla[] numerosBombolla = new NumeroBombolla[4];
        
        for (int i = 0; i < numRandom.length; i++) {
            numRandom[i] = (int) (Math.random() * numeros) + 1;
        }

        System.out.println(Arrays.toString(numRandom));

        int contadorAux = 0;
        for (int i = 0; i < numerosBombolla.length; i++) {
            int[] arrayAux = new int[numRandom.length / 4];
            for (int j = 0; j < arrayAux.length; j++) {
                arrayAux[j] = numRandom[contadorAux];
                contadorAux++;
            }
            NumeroBombolla arrayBomb = new  NumeroBombolla(arrayAux, i);
            numerosBombolla[i] = arrayBomb;
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        
        
    }
}
