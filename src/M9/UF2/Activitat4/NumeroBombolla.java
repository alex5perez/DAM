/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF2.Activitat4;

/**
 *
 * @author alexp
 */
public class NumeroBombolla implements Runnable{
    
    int[] array;
    int grup;
    
    public NumeroBombolla(int[] numerosBombolla, int grup) {
        this.array = numerosBombolla;
        this.grup = grup;
    }

    @Override
    public void run() {
        int aux, i, j;
        int[] grupBom;
        for (i = 1; i < array.length; i++) {
            for (j= 0; i < array.length - i; j++) {
                
                if (array[j] > array[j + 1]) {
                    grupBom = array.clone();
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}
