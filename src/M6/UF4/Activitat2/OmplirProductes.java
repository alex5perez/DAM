package M6.UF4.Activitat2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ElsMeusBeans.Comanda;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import ElsMeusBeans.Producte;

/**
 *
 * @author alexp
 */

public class OmplirProductes {
    public static void main (String[] args) {
        //Obrir la base de dades
        Producte[] productes = {
        new Producte(1, "Barcelona, Una biografia", 10, 3, 160),
        new Producte(2, "La magia de l'ordre", 5, 2, 176),
        new Producte(3, "Tot es al teu cap", 20, 5, 193),
        new Producte(4, "Filosofía inacabada", 8, 3, 85),
        new Producte(5, "La resistència íntima", 7, 1, 159),
        new Producte(6, "El capital al segle xxi", 5, 2, 80)};
        
            for (int i=0; i<productes.length; i++){


            Comanda comanda = new Comanda();

            productes[i].addPropertyChangeListener(comanda);
            //Es canvia l'estoc actual, se li dona valor 2
            productes[i].setStockactual(2);
            
            }
    }
}

