/*
Heu de desenvolupar una aplicació que permeti fer el manteniment dels vehicles 
que gestiona una taller de cotxes.
La informació s'ha d'emmagatzemar en una bdoo que, com a mínim, ha de contenir 
objectes de tipus vehicles i de tipus propietaris.
Identifiqueu per a cada tipus d'objecte els camps necessaris i teniu en compte
que, entre tots els objectes que emmagatzemareu en la bdoo, hi ha d'haver,
com a mínim, un camp de tipus String, un de tipus data, un de tipus enter, i un de tipus booleà.
La interfície de l'aplicació és lliure, però és valorarà més l'ús d'una 
interfície visual enlloc de text, i la usabilitat, la coherència i l'ordre de la interfície també comptaran més.
L'aplicació ha de permetre llistar les dades dels vehicles, les dades dels 
propietaris i les dades de la resta d'objectes que emmagatzemeu en la bdoo.
*/
package M6.UF2.Activitat8.coches;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
* File: Exercici8UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 17-11-2020
* Description: Activitat 8 PRACTICA UF2 M6
*/

@Entity
public class Propietaris implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
        //variables
        @Id @GeneratedValue
        Long id;
        private String nom;
        private int edat;
    
            public Propietaris(String nom, int edat) {
                this.nom = nom;
                this.edat = edat;
            }

                //Sets i Gets
                public String getNom() {
                    return nom;
                }

                public void setNom(String nom) {
                    this.nom = nom;
                }

                public int getEdat() {
                    return edat;
                }

                public void setEdat(int edat) {
                    this.edat = edat;
                }
}
