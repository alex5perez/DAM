/*
Al programa MaximTask (podeu trobar en el pdf del moodle) cal fer les 
modificacions necessàries per què mostri per terminal el nombre de vegades que 
s'executa compute() i la divisió que fa del array cada vegada que es crida 
MaximTask de manera semblant a la que es pot veure a la següent sortida:
 */
package M9.UF2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/*
* File: Exercici3UF2M9.java 
* Author: Alex Pérez Rubio i Hector Garzon Borras
* Date: 17-01-2021
* Description: Activitat 3 PRACTICA UF2 M9
*/
public class MaximTask extends RecursiveTask<Short> {
    //private static final int LLINDAR=10000000;
    private static final int LLINDAR = 10000000;
    private short[] arr;
    private int inici, fi;
    //Variables noves
    private static int cont;
    private static final String CONT = "Comptador ";
    private static final String INI = "Inici ";
    private static final String FIN = "Final ";
    
    public MaximTask(short[] arr, int inici, int fi) {
        
        this.arr = arr;
        this.inici = inici;
        this.fi = fi;
        
    }

    private short getMaxSeq() {
        
        short max = arr[inici];
        
        for (int i = inici + 1; i < fi; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //Augment
        cont++;
        //Print per ver tot
        System.out.println(CONT + cont + INI + inici + FIN + fi);
        return max;
    }

    private short getMaxReq() {
        MaximTask task1;
        MaximTask task2;
        int mig = (inici + fi) / 2 + 1;
        task1 = new MaximTask(arr, inici, mig);
        task1.fork();
        task2 = new MaximTask(arr, mig, fi);
        task2.fork();
        //Augment
        cont++;
        //Print per ver tot
        System.out.println(CONT + cont + INI + inici + FIN + fi);
        return (short) Math.max(task1.join(), task2.join());
    }

    @Override
    protected Short compute() {
        if (fi - inici <= LLINDAR) {
            return getMaxSeq();
        } else {
            return getMaxReq();
        }
    }

    public static void main(String[] args) {
        
        short[] data = createArray(100000000);
        //Mira el numero de processadors
        System.out.println("Inici càlcul");
        ForkJoinPool pool = new ForkJoinPool();
        
        int inici = 0;
        int fi=data.length;
        MaximTask tasca = new MaximTask(data, inici, fi);
        
        long time = System.currentTimeMillis();
        //crida la tasca i espera que es completin
        int result1 = pool.invoke(tasca);
        //màxim
        int result = tasca.join();
        System.out.println("Temps utilitzat:" + (System.currentTimeMillis() - time));
        System.out.println("Màxim es " + result);
    }

    private static short[] createArray(int size) {
        short[] ret = new short[size];
        for (int i=0; i<size; i++) {
            ret[i] = (short) (1000 * Math.random());
            if (i == ((short) (size*0.9))) {
                ret[i] = 1005;
            }
        }
        
        return ret;
    }
}