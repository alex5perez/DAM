/*
•Crea un pool de 4 fils.
•La primera vegada al cap de 5 segons i posteriorment cada 6 segons.
•Cal deixar temps suficient per que s'executin 5 tasques.
•Les tasques es realitzen de manera paral•lela.
•Cal comentar el codi explicant-ho que fa cada operació cabdal.

 */
package M9.UF2.Activitat2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
* File: Exercici2UF2M9.java 
* Author: Alex Pérez Rubio
* Date: 20-12-2020
* Description: Activitat 2 PRACTICA UF2 M9
*/
public class Ex2uf2m9 {

        public static void main(final String... args) throws InterruptedException, ExecutionException {
        //mostrem hora actual abans d’execució
    Calendar calendario = new GregorianCalendar();
    System.out.println("Inici: "+ calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) +
        ":" + calendario.get(Calendar.SECOND));
    // Crea un pool de 2 fils (ara son 4)
    final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(4);
    // Crea objecte Runnable.
    final Runnable ob = new Ex2uf2m9().new ExecutaFil();
    // Programa Fil, s’inicia als 2 segons i després es va executant cada 3 segons (ara son 6)
    schExService.scheduleWithFixedDelay(ob, 5, 6, TimeUnit.SECONDS);
    // Espera per acabar 10 segons (ara son 30)
    schExService.awaitTermination(30, TimeUnit.SECONDS);
    // shutdown .
    schExService.shutdownNow();
    System.out.println("Completat");
    }

    // Fil Runnable
    class ExecutaFil implements Runnable {
        @Override
        public void run() {
            Calendar calendario = new GregorianCalendar();
            System.out.println("Hora execució tasca: "+
                calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                calendario.get(Calendar.MINUTE) + ":" +
                calendario.get(Calendar.SECOND));
            System.out.println("Tasca en execució");
            System.out.println("Execució acabada");
            }
        }
    }

