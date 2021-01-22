/*
Mitjançant el patró ThreadPoolExecutor heu de simular 
el moviment dels caixers d’un supermercat. 
 */
package M9.UF2.Activitat4;

/*
* File: Exercici9UF2M9.java 
* Author: Alex Pérez Rubio i Hector Garzon Borras
* Date: 22-01-2021
* Description: Activitat 4 PRACTICA UF2 M9
*/
public class apartat1 {
    
    static class Caixa implements Runnable {
        private int[] temps = {2, 3, 4, 5, 6, 7, 8};
        private int numClient;
        
        public Caixa(int i) {
            numClient = i;
        }
    }
    
    
}
