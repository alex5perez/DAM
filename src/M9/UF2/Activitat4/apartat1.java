/*
Mitjançant el patró ThreadPoolExecutor heu de simular 
el moviment dels caixers d’un supermercat. 
 */
package M9.UF2.Activitat4;

import java.util.concurrent.*;

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

        @Override
        public void run() {
            int articlesRandom = (int) (Math.random() * (30 - 1 + 1)) + 1;
            int tempsRandom;
            
            System.out.println("Creat Client " + numClient + " amb " + articlesRandom + " articles.");
            System.out.println("Client " + numClient + " passa per caixa ");
            for (int j = 1; j < articlesRandom; j++) {
                tempsRandom = (int) (Math.random() * (6 - 0 + 1));
                try {
                    Thread.sleep(temps[tempsRandom] * 1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (j == articlesRandom) {
                    System.out.println("Client " + numClient + " article " + j + "/" + articlesRandom + " (" + temps[tempsRandom] + " segons) FINALITZAT");
                }else{
                    System.out.println("Client " + numClient + " article " + j + "/" + articlesRandom + " (" + temps[tempsRandom] + " segons)");
                }
            }
        }
    
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool (10);
        
        for (int i = 1; i <= 500; i++) {
            Caixa task = new Caixa(i);
            executor.scheduleWithFixedDelay(task, 0 , 3, TimeUnit.SECONDS);
    }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
