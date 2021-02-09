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
public class RunnableFil implements Runnable {
    String strImprimir;
        public RunnableFil(String strP) {
            strImprimir=strP;
        }

    public void run(){
    for(int x=0;x<6;x++){
        System.out.println(strImprimir+ " " + x);
        
        }
    
    }

    public static void main(String[] args) {

        //Creem dos objecte de la classe 
        RunnableFil objRunnable1 = new RunnableFil("Fil 1");
        RunnableFil objRunnable2 = new RunnableFil("Fil 2");
        RunnableFil objRunnable3 = new RunnableFil("Fil 3");
        RunnableFil objRunnable4 = new RunnableFil("Fil 4");
        RunnableFil objRunnable5 = new RunnableFil("Fil 5");
        RunnableFil objRunnable6 = new RunnableFil("Fil 6");
        //Creem dos Fils i li passem per paràmetres els objecte de la classeRunnableFil
        Thread primer = new Thread(objRunnable1);
        Thread segon = new Thread(objRunnable2);
        Thread tres = new Thread(objRunnable3);
        Thread cuatre = new Thread(objRunnable4);
        Thread cinc = new Thread(objRunnable5);
        Thread sis = new Thread(objRunnable6);
        // Hem creat dos fils primer i segon, però no s’han executat.
        // Per poder−lo executar s’ha de cridar al mètode start()
        primer.start();
        segon.start();
        tres.start();
        cuatre.start();
        cinc.start();
        sis.start();
        
        System.out.println("Final Fil Principal");
        
    }
    
}