/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF4.Activitat1;

import ElsMeusBeans.Producte;
import ElsMeusBeans.Comanda;
/**
 *
 * @author alexp
 */
public class Activitat1 {
    public static void main (String[] args) {
        Producte[] productes = {
            new Producte(1, "Portable MSI USB 3.0", 10, 3, 50),
            new Producte(2, "Portatil ASUS I7", 10, 3, 50),
            new Producte(3, "Teclado MARS GAMING", 10, 3, 50),
            new Producte(4, "Raton GAMER", 10, 3, 50),
            new Producte(5, "Fuente 750W", 10, 3, 50),
            new Producte(6, "Silla GAMING LOKI VERDE", 10, 3, 20),
            new Producte(7, "Monitor/TV HP 25pulgadas", 10, 3, 50),
            new Producte(8, "Grafica GTX GEFORCE 3060ti", 10, 3, 0),
            new Producte(9, "Placa M2 MSI", 10, 3, 50),
            new Producte(10, "RAM 16GB X2", 10, 3, 50),
                                                    };
        
        
        Comanda comanda = new Comanda();
        
        productes[i].addPropertyChangeListener(comanda);
        //Es canvia l'estoc actual, se li dona valor 2
        productes[i].setStockactual(2);
        if (comanda.isDemana()) {
            System.out.println("Fer comanda en producte: " +producte.getDescripcio());
        }else
            System.out.println("No és necessari fer la comanda en producte: " +producte.getDescripcio());
    }
}
