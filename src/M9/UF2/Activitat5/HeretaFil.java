/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF2.Activitat5;

/**
 *
 * @author alexp
 */
public class HeretaFil extends Thread {
    String strImprimir;
    public HeretaFil(String strP){
        strImprimir = strP;
    }
    
    public void run() {
        for (int x= 0; x<5; x++){
            System.out.println(strImprimir+ " " + x);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread primer = new HeretaFil("Fil 1");
        Thread segon = new HeretaFil("Fil 2");
        Thread tercer = new HeretaFil("Fil 3");
        Thread cuart = new HeretaFil("Fil 4");
        Thread cinque = new HeretaFil("Fil 5");
        Thread sise = new HeretaFil("Fil 6");
        Thread sete = new HeretaFil("Fil 7");
        Thread vuite = new HeretaFil("Fil 2");
        Thread nove = new HeretaFil("Fil 2");
        Thread dese = new HeretaFil("Fil 2");
        primer.run();
        segon.run();
        tercer.start();
        cuart.start();
        cinque.start();
        sise.start();
        sete.start();
        vuite.start();
        nove.start();
        dese.start();
        
        System.out.println("Final Fil Principal");
    }
    
}