/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF2;

/*
* File: Exercici3UF2M9.java 
* Author: Alex Pérez Rubio i Hector Garzon Borras
* Date: 17-01-2021
* Description: Activitat 3 PRACTICA UF2 M9
*/
public class Activitat3 {
    
    public static long calculaFibonacci(long numero) {
        double calcul = java.lang.Math.cos(54879854);
        if (numero==0) { return 0; }
        else if (numero==1) { return 1; }
        else {
            return (calculaFibonacci(numero-2) + calculaFibonacci(numero-1));
        }
    }

}
