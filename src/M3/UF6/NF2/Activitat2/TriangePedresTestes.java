/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.NF2.Activitat2;

/**
 *
 * @author alexp
 */
public class TriangePedresTestes {
    
    public static void main( String[] args ) {
        int pedres = 10;
        int cont;
        int fila = 1;
        int pedresno = 0;
        
        for ( cont =0; cont < pedres; cont++) {
            pedresno += fila;
            fila++;
            if ( pedresno == pedres ) {
                System.out.println( --fila + "," + 0);
                break;
            }else if ( ( pedresno + fila ) > pedres ) {
                System.out.println( --fila + "," + ( pedres - pedresno) );
            }
        }
    }
}
